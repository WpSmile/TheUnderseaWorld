package com.qifeng.theunderseaworld.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.adapter.CartAdapter;
import com.qifeng.theunderseaworld.adapter.CartTuijianAdapter;
import com.qifeng.theunderseaworld.bean.CartBean;
import com.qifeng.theunderseaworld.bean.CartTuijianBean;
import com.qifeng.theunderseaworld.utils.MFGT;
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

    int pageId = 1;
    ArrayList<CartBean> mTodayActivityList;
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
        if (Build.VERSION.SDK_INT>Build.VERSION_CODES.KITKAT){
            //沉侵
            StatusBarCompat.compat(this,getResources().getColor(R.color.bottom_blue));
        }
        ButterKnife.bind(this);

        mContext = this;
        mTodayActivityList = new ArrayList<>();
        tuijianList = new ArrayList<>();

        initView();
        initData();
        setListener();
    }

    private void initView() {
        phoneRegisterTxtTitle.setText("购物车");


        MyManager = new LinearLayoutManager(mContext);
        mAdapter = new CartAdapter(mContext, mTodayActivityList);
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
        for (int i=0;i<10;i++){
            mTodayActivityList.add(bean);
        }


        gridLayoutManager = new GridLayoutManager(mContext,3,LinearLayoutManager.VERTICAL,false);
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
        for (int i=0;i<3;i++){
            tuijianList.add(cartTuijianBean);
        }


    }
    private void setListener() {
        setOnPullUpListener();//上拉加载
        setOnPullDownListener();//下拉刷新
    }

    private void setOnPullDownListener() {

    }

    private void setOnPullUpListener() {
        //todayActivitySrl.setVisibility(View.GONE);
        cartRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            int lastposition;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                lastposition = MyManager.findLastVisibleItemPosition();
                if (newState != RecyclerView.SCROLL_STATE_DRAGGING) {
                    mAdapter.notifyDataSetChanged();
                }
                if (lastposition >= mAdapter.getItemCount() - 1
                        && newState == RecyclerView.SCROLL_STATE_IDLE
                        && mAdapter.isMore()) {
                    pageId++;
                    //downloadBoutique(I.ACTION_PULL_UP);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastposition = MyManager.findLastVisibleItemPosition();
            }
        });
    }

    private void initData() {

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
                break;
        }
    }
}
