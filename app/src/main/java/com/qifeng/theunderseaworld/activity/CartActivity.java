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
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qifeng.theunderseaworld.I;
import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.UnderseaWorldApplication;
import com.qifeng.theunderseaworld.adapter.CartAdapter;
import com.qifeng.theunderseaworld.adapter.CartTuijianAdapter;
import com.qifeng.theunderseaworld.bean.CartBean;
import com.qifeng.theunderseaworld.bean.CartTuijianBean;
import com.qifeng.theunderseaworld.bean.User;
import com.qifeng.theunderseaworld.utils.HttpRequestWrap;
import com.qifeng.theunderseaworld.utils.MFGT;
import com.qifeng.theunderseaworld.utils.OkUtils;
import com.qifeng.theunderseaworld.utils.OnResponseHandler;
import com.qifeng.theunderseaworld.utils.RequestHandler;
import com.qifeng.theunderseaworld.utils.RequestStatus;
import com.qifeng.theunderseaworld.utils.StatusBarCompat;
import com.qifeng.theunderseaworld.view.SpaceItemDecoretion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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


        myReceiver = new updateCartReceiver();


        gridLayoutManager = new GridLayoutManager(mContext, 3, LinearLayoutManager.VERTICAL, false);
        cartTuijianAdapter = new CartTuijianAdapter(mContext, tuijianList);
        cartRvTuijian.setAdapter(cartTuijianAdapter);
        cartRvTuijian.setLayoutManager(gridLayoutManager);
        //设置是否自动修复
        cartRvTuijian.setHasFixedSize(true);
        cartRvTuijian.addItemDecoration(new SpaceItemDecoretion(12));


    }


    private void initData() {
        downloadCart();

        downloadGuessLike();
    }

    private void downloadGuessLike() {//获取为你推荐数据的方法
        HttpRequestWrap httpRequestWrap;
        httpRequestWrap = new HttpRequestWrap(mContext);
        httpRequestWrap.setMethod(HttpRequestWrap.POST);
        httpRequestWrap.setCallBack(new RequestHandler(mContext, new OnResponseHandler() {
            @Override
            public void onResponse(String s, RequestStatus status) {
                if (status == RequestStatus.SUCCESS) {
                    if (!s.isEmpty()) {
                        JSONObject jsonObject = JSONObject.parseObject(s);
                        JSONObject j = jsonObject.getJSONObject("result");
                        JSONArray array = j.getJSONArray("retData");
                        for (int i = 0; i < array.size(); i++) {
                            CartTuijianBean bean = new CartTuijianBean();
                            JSONObject x = array.getJSONObject(i);
                            bean.setGoodsId(x.getString("goods_id"));
                            bean.setGoodsTitle(x.getString("goods_title"));
                            bean.setGoodsPrice(x.getString("goods_price"));
                            bean.setImage(x.getString("image"));
                            tuijianList.add(bean);

                        }

                        cartTuijianAdapter.initData(tuijianList);

                    }
                }
            }
        }));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("num", 3 + "");
        httpRequestWrap.send(I.SERVER_URL + "HootGoods" + I.INDEX, map);
    }

    private void downloadCart() {//获取购物车数据的方法
        user = UnderseaWorldApplication.getUser();
        if (user != null){//当用户不为空时才显示购物车中的数据
            HttpRequestWrap httpRequestWrap;
            httpRequestWrap = new HttpRequestWrap(mContext);
            httpRequestWrap.setMethod(HttpRequestWrap.POST);
            httpRequestWrap.setCallBack(new RequestHandler(mContext, new OnResponseHandler() {
                @Override
                public void onResponse(String s, RequestStatus status) {
                    if (status == RequestStatus.SUCCESS) {
                        if (!s.isEmpty()) {
                            JSONObject jsonObject = JSONObject.parseObject(s);
                            Log.e("tag","jsonObject!!!!!!!!!!!!!!!!!!!"+jsonObject.toString());
                            JSONArray jsonArray = jsonObject.getJSONArray(s);
                            for (int i = 0 ;i<jsonArray.size();i++){
                                CartBean bean = new CartBean();
                                String goods_id = jsonObject.getString("goods_id");
                                String image = jsonObject.getString("image");
                                String goods_price = jsonObject.getString("goods_price");
                                String goods_title = jsonObject.getString("goods_title");
                                String goods_details = jsonObject.getString("goods_details");
                                String goods_num = jsonObject.getString("goods_num");

                                bean.setImage(image);
                                bean.setGoodsDetails(goods_details);
                                bean.setGoodsPrice(goods_price);
                                bean.setGoodsTitle(goods_title);
                                bean.setGoodsId(goods_id);
                                bean.setGoodsNum(goods_num);

                                cartlist.add(bean);
                            }
                            mAdapter.initData(cartlist);
                        }
                    }
                }
            }));
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("num", user.getUserId() + "");
            httpRequestWrap.send(I.SERVER_URL + "GetShopcart" + I.INDEX, map);

        }
    }



    /*private void sumPrice(){
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
    }*/

    private int getPrice(String price) {
        price = price.substring(price.indexOf("￥")+1);
        return Integer.valueOf(price);
    }

    class updateCartReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            //sumPrice();
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
