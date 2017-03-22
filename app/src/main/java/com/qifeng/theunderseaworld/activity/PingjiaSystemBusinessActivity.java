package com.qifeng.theunderseaworld.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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

public class PingjiaSystemBusinessActivity extends AppCompatActivity {
    private final static String TAG = PingjiaSystemBusinessActivity.class.getCanonicalName();
    PingjiaSystemBusinessActivity mContext;

    @BindView(R.id.reply_tv_num)
    TextView replyTvNum;
    @BindView(R.id.pingjia_system_recyclerView)
    RecyclerView pingjiaSystemRecyclerView;

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
        //获取登录时的任务信息
        //User user = UnderseaWorldApplication.getUser();
        //String nick = user.getMuserNick();
        //if ("顾客".equals(nick)) {//如果是顾客
            /*调用顾客的adapter并在里面设置相应的item*/
        initViewCustomer();

       // } else {//如果是商家
            /*调用商家的adapter并在里面设置相应的item*/
        initViewBusiness();
        //}
    }

    private void initViewBusiness() {

    }

    private void initViewCustomer() {
        pingjiaCustomerBeenlist = new ArrayList<>();
        PingjiaBusinessBean PingjiaBusinessBean = new PingjiaBusinessBean();
        PingjiaBusinessBean.setAvatar(R.drawable.login_background_image);
        PingjiaBusinessBean.setNick("会飞的鱼");
        PingjiaBusinessBean.setPingjia("买票很方便，非常不错！");
        PingjiaBusinessBean.setTime("2017-03-21");
        for (int i=0;i<10;i++){
            pingjiaCustomerBeenlist.add(PingjiaBusinessBean);
        }

        linearLayoutManager = new LinearLayoutManager(mContext);
        PingjiaBusinessAdapter = new PingjiaBusinessAdapter(mContext,pingjiaCustomerBeenlist);

        pingjiaSystemRecyclerView.setAdapter(PingjiaBusinessAdapter);
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
