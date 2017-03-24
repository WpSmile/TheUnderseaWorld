package com.qifeng.theunderseaworld.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.UnderseaWorldApplication;
import com.qifeng.theunderseaworld.adapter.PingjiaCustomerAdapter;
import com.qifeng.theunderseaworld.bean.PingjiaCustomerBean;
import com.qifeng.theunderseaworld.bean.User;
import com.qifeng.theunderseaworld.utils.MFGT;
import com.qifeng.theunderseaworld.utils.StatusBarCompat;
import com.qifeng.theunderseaworld.view.SpaceItemDecoretion;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
* 顾客评价系统
* */
public class PingjiaSystemActivity extends AppCompatActivity {
    private final static String TAG = PingjiaSystemActivity.class.getCanonicalName();
    PingjiaSystemActivity mContext;

    @BindView(R.id.reply_tv_num)
    TextView replyTvNum;
    @BindView(R.id.pingjia_system_recyclerView)
    RecyclerView pingjiaSystemRecyclerView;

    int pageId = 1;
    ArrayList<PingjiaCustomerBean> pingjiaCustomerBeenlist;
    PingjiaCustomerAdapter pingjiaCustomerAdapter;
    LinearLayoutManager linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //API19以下用于沉侵式菜单栏
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_pingjia_system);
        //API20以上
        if (Build.VERSION.SDK_INT>Build.VERSION_CODES.KITKAT){
            //沉侵
            StatusBarCompat.compat(this,getResources().getColor(R.color.bottom_blue));
        }
        ButterKnife.bind(this);

        mContext = this;


        initView();
        initData();
        setListener();
    }

    private void setListener() {
        setOnPullUpListener();//加载
    }

    private void setOnPullUpListener() {
        //todayActivitySrl.setVisibility(View.GONE);
        pingjiaSystemRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            int lastposition;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                lastposition = linearLayoutManager.findLastVisibleItemPosition();
                if (newState != RecyclerView.SCROLL_STATE_DRAGGING) {
                    pingjiaCustomerAdapter.notifyDataSetChanged();
                }
                if (lastposition >= pingjiaCustomerAdapter.getItemCount() - 1
                        && newState == RecyclerView.SCROLL_STATE_IDLE
                        && pingjiaCustomerAdapter.isMore()) {
                    pageId++;
                    //downloadBoutique(I.ACTION_PULL_UP);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastposition = linearLayoutManager.findLastVisibleItemPosition();
            }
        });
    }

    private void initData() {

    }

    private void initView() {
        pingjiaCustomerBeenlist = new ArrayList<>();
        PingjiaCustomerBean pingjiaCustomerBean = new PingjiaCustomerBean();
        pingjiaCustomerBean.setAvatar(R.drawable.login_background_image);
        pingjiaCustomerBean.setNick("会飞的鱼");
        pingjiaCustomerBean.setPingjia("买票很方便，非常不错！");
        pingjiaCustomerBean.setTime("2017-03-21");
        pingjiaCustomerBean.setImage1(R.drawable.login_background_image);
        for (int i=0;i<10;i++){
            pingjiaCustomerBeenlist.add(pingjiaCustomerBean);
        }

        linearLayoutManager = new LinearLayoutManager(mContext);
        pingjiaCustomerAdapter = new PingjiaCustomerAdapter(mContext,pingjiaCustomerBeenlist);

        pingjiaSystemRecyclerView.setAdapter(pingjiaCustomerAdapter);
        pingjiaSystemRecyclerView.setLayoutManager(linearLayoutManager);

        pingjiaSystemRecyclerView.hasFixedSize();
        pingjiaSystemRecyclerView.addItemDecoration(new SpaceItemDecoretion(12));
    }


    @OnClick({R.id.Pingjia_system_img_back, R.id.pingjia_system_img, R.id.pingjia_system_btn_fangbian, R.id.pingjia_system_btn_pianyi, R.id.pingjia_system_btn_kuaijie})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Pingjia_system_img_back:
                MFGT.finish(mContext);
                break;
            case R.id.pingjia_system_img://用户发表评论的按钮
                MFGT.gotoCommentActivity(mContext);
                break;
            case R.id.pingjia_system_btn_fangbian://方便
                break;
            case R.id.pingjia_system_btn_pianyi://便宜
                break;
            case R.id.pingjia_system_btn_kuaijie://快捷
                break;
        }
    }
}
