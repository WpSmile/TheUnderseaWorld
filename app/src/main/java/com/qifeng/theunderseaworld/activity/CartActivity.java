package com.qifeng.theunderseaworld.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.qifeng.theunderseaworld.I;
import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.UnderseaWorldApplication;
import com.qifeng.theunderseaworld.adapter.CartAdapter;
import com.qifeng.theunderseaworld.adapter.CartTuijianAdapter;
import com.qifeng.theunderseaworld.bean.CartBean;
import com.qifeng.theunderseaworld.bean.CartTuijianBean;
import com.qifeng.theunderseaworld.bean.User;
import com.qifeng.theunderseaworld.utils.MFGT;
import com.qifeng.theunderseaworld.utils.OkUtils;
import com.qifeng.theunderseaworld.utils.StatusBarCompat;
import com.qifeng.theunderseaworld.view.SpaceItemDecoretion;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CartActivity extends AppCompatActivity {

    @BindView(R.id.phone_register_txtTitle)
    TextView phoneRegisterTxtTitle;
    @BindView(R.id.cart_recyclerView)
    RecyclerView cartRecyclerView;
    @BindView(R.id.tv_count_num)
    TextView tvCountNum;
    @BindView(R.id.cart_rv_tuijian)
    RecyclerView cartRvTuijian;

    User user = null;
    String cartIds = "";
    updateCartReceiver myReceiver;

    int pageId = 1;
    ArrayList<CartBean> cartlist;
    LinearLayoutManager MyManager;
    CartAdapter mAdapter;
    CartActivity mContext;


    CartTuijianAdapter cartTuijianAdapter;
    GridLayoutManager gridLayoutManager;
    ArrayList<CartTuijianBean> tuijianList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //API19以下用于沉侵式菜单栏
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_cart);
        //API20以上
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            //沉侵
            StatusBarCompat.compat(this, getResources().getColor(R.color.bottom_blue));
        }
        ButterKnife.bind(this);

        mContext = this;
        cartlist = new ArrayList<>();
        tuijianList = new ArrayList<>();

        initView();
        initData();
        setListener();
    }

    private void setListener() {
        IntentFilter intentFilter = new IntentFilter(I.BROADCASE_UPDATE_CART);
        registerReceiver(myReceiver,intentFilter);
    }

    private void initView() {
        phoneRegisterTxtTitle.setText("购物车");


        MyManager = new LinearLayoutManager(mContext);
        mAdapter = new CartAdapter(mContext, cartlist);
        cartRecyclerView.setAdapter(mAdapter);
        cartRecyclerView.setLayoutManager(MyManager);
        //设置是否自动修复
        cartRecyclerView.setHasFixedSize(true);
        cartRecyclerView.addItemDecoration(new SpaceItemDecoretion(12));
        CartBean bean = new CartBean();
        bean.setImage(R.drawable.today_activity_default);
        bean.setName("海底世界儿童票");
        bean.setCount(1);
        bean.setPrice(35);
        for (int i = 0; i < 10; i++) {
            cartlist.add(bean);
        }

        myReceiver = new updateCartReceiver();


        gridLayoutManager = new GridLayoutManager(mContext, 3, LinearLayoutManager.VERTICAL, false);
        cartTuijianAdapter = new CartTuijianAdapter(mContext, tuijianList);
        cartRvTuijian.setAdapter(cartTuijianAdapter);
        cartRvTuijian.setLayoutManager(gridLayoutManager);
        //设置是否自动修复
        cartRvTuijian.setHasFixedSize(true);
        cartRvTuijian.addItemDecoration(new SpaceItemDecoretion(12));
        CartTuijianBean cartTuijianBean = new CartTuijianBean();
        cartTuijianBean.setImage(R.drawable.today_activity_default);
        cartTuijianBean.setTitle("南宁海底世界");
        cartTuijianBean.setPrice(35);
        cartTuijianBean.setTicketStyle("老年票");
        for (int i = 0; i < 3; i++) {
            tuijianList.add(cartTuijianBean);
        }


    }


    private void initData() {
        downloadCart();

        downloadGuessLike();
    }

    private void downloadGuessLike() {//获取才你喜欢数据的方法

    }

    private void downloadCart() {//获取购物车数据的方法
        user = UnderseaWorldApplication.getUser();
        if (user != null){//当用户不为空时才显示购物车中的数据
            OkUtils<String> utils = new OkUtils<>(mContext);
            utils.url(I.SERVER_URL+""+I.INDEX)
                    .addParam("","")
                    .post()
                    .targetClass(String.class)
                    .execute(new OkUtils.OnCompleteListener<String>() {
                        @Override
                        public void onSuccess(String s) {

                        }

                        @Override
                        public void onError(String error) {

                        }
                    });

        }
    }



    private void sumPrice(){
        cartIds = "";

        int sumPrice = 0;
        int savPrive = 0;
        if (cartlist!=null&&cartlist.size()>0){
            for (CartBean c:cartlist){
                if (c.isChecked()){
                    cartIds += c.getId()+",";

                    //sumPrice+=getPrice(c.getGoods().getCurrencyPrice())*c.getCount();
                    //savPrive+=getPrice(c.getGoods().getRankPrice())*c.getCount();
                }
            }

            tvCountNum.setText("￥"+Double.valueOf(savPrive));
            //tvSaveNum.setText("￥"+Double.valueOf(sumPrice-savPrive));
        }else {
            cartIds = "";
            tvCountNum.setText("￥0");
            //tvSaveNum.setText("￥0");
        }
    }

    private int getPrice(String price) {
        price = price.substring(price.indexOf("￥")+1);
        return Integer.valueOf(price);
    }

    class updateCartReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            sumPrice();
            //setCartLayout(cartlist!=null&&cartlist.size()>0);
        }
    }

    @OnClick({R.id.phone_register_img_back, R.id.cart_id_checkbox, R.id.id_checkbox1, R.id.btBuy})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.phone_register_img_back:
                MFGT.finish(this);
                break;
            case R.id.cart_id_checkbox:
                break;
            case R.id.id_checkbox1:
                break;
            case R.id.btBuy:
                if (cartIds!=null&&cartIds.length()>0){
                    //MFGT.gotoOrderActivity(mContext,cartIds);
                }else {
                    Toast.makeText(mContext,R.string.order_nothing , Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (myReceiver!=null){
            unregisterReceiver(myReceiver);
        }
    }
}
