package com.qifeng.theunderseaworld.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.adapter.PingjiaBusinessAdapter;
import com.qifeng.theunderseaworld.bean.PingjiaBusinessBean;
import com.qifeng.theunderseaworld.utils.MFGT;
import com.qifeng.theunderseaworld.view.SpaceItemDecoretion;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
*
* 商家评价系统
* */
public class PingjiaSystemBusinessActivity extends AppCompatActivity {
    private final static String TAG = PingjiaSystemBusinessActivity.class.getCanonicalName();
    PingjiaSystemBusinessActivity mContext;

    @BindView(R.id.pingjia_system_recyclerView)
    RecyclerView pingjiaSystemRecyclerView;
    @BindView(R.id.pingjia_system_img)
    ImageView pingjiaSystemImg;
    @BindView(R.id.pingjia_system_btn_rl)
    RelativeLayout pingjiaSystemBtnRl;
    @BindView(R.id.pingjia_system_ll)
    LinearLayout pingjiaSystemLl;

    int pageId = 1;
    ArrayList<PingjiaBusinessBean> pingjiaCustomerBeenlist;
    PingjiaBusinessAdapter PingjiaBusinessAdapter;
    LinearLayoutManager linearLayoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pingjia_system);
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
                    PingjiaBusinessAdapter.notifyDataSetChanged();
                }
                if (lastposition >= PingjiaBusinessAdapter.getItemCount() - 1
                        && newState == RecyclerView.SCROLL_STATE_IDLE
                        && PingjiaBusinessAdapter.isMore()) {
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
        pingjiaSystemLl.setVisibility(View.GONE);
        pingjiaSystemImg.setVisibility(View.GONE);
        pingjiaSystemBtnRl.setVisibility(View.GONE);

        pingjiaCustomerBeenlist = new ArrayList<>();
        PingjiaBusinessBean PingjiaBusinessBean = new PingjiaBusinessBean();
        PingjiaBusinessBean.setAvatar(R.drawable.login_background_image);
        PingjiaBusinessBean.setNick("会飞的鱼");
        PingjiaBusinessBean.setPingjia("方便快捷，以后还会光顾的！");
        PingjiaBusinessBean.setTime("2017-03-21");
        for (int i = 0; i < 10; i++) {
            pingjiaCustomerBeenlist.add(PingjiaBusinessBean);
        }

        linearLayoutManager = new LinearLayoutManager(mContext);
        PingjiaBusinessAdapter = new PingjiaBusinessAdapter(mContext, pingjiaCustomerBeenlist);

        pingjiaSystemRecyclerView.setAdapter(PingjiaBusinessAdapter);
        pingjiaSystemRecyclerView.setLayoutManager(linearLayoutManager);

        pingjiaSystemRecyclerView.hasFixedSize();
        pingjiaSystemRecyclerView.addItemDecoration(new SpaceItemDecoretion(12));
    }


    @OnClick({R.id.Pingjia_system_img_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Pingjia_system_img_back:
                MFGT.finish(mContext);
                break;
        }
    }
}
