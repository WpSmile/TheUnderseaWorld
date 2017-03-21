package com.qifeng.theunderseaworld.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.adapter.TodayActivityAdapter;
import com.qifeng.theunderseaworld.bean.TodayActivityBean;
import com.qifeng.theunderseaworld.utils.L;
import com.qifeng.theunderseaworld.utils.MFGT;
import com.qifeng.theunderseaworld.view.SpaceItemDecoretion;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TodayActivity extends AppCompatActivity {
    private final static String TAG = TodayActivity.class.getCanonicalName();

    @BindView(R.id.phone_register_txtTitle)
    TextView phoneRegisterTxtTitle;
    @BindView(R.id.today_text_refresh)
    TextView todayTextRefresh;
    @BindView(R.id.today_recyclerView)
    RecyclerView todayRecyclerView;
    @BindView(R.id.today_activity_srl)
    SwipeRefreshLayout todayActivitySrl;


    int pageId = 1;
    ArrayList<TodayActivityBean> mTodayActivityList;
    LinearLayoutManager MyManager;
    TodayActivityAdapter mAdapter;
    TodayActivity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);
        ButterKnife.bind(this);
        mContext = this;
        mTodayActivityList = new ArrayList<>();

        initView();
        initData();
        setListener();
    }

    private void setListener() {
        setOnPullUpListener();//上拉加载
        setOnPullDownListener();//下拉刷新
    }

    private void setOnPullDownListener() {
        todayActivitySrl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                todayActivitySrl.setRefreshing(true);
                todayActivitySrl.setEnabled(true);
                todayTextRefresh.setVisibility(View.VISIBLE);
                pageId = 1;
                //downloadBoutique(I.ACTION_PULL_DOWN);
            }
        });
    }

    private void setOnPullUpListener() {
        //todayActivitySrl.setVisibility(View.GONE);
        todayRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
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

    private void initView() {
        phoneRegisterTxtTitle.setText("今日活动");
        CharSequence text = phoneRegisterTxtTitle.getText();
        L.e(TAG,text.toString());

        MyManager = new LinearLayoutManager(mContext);
        mAdapter = new TodayActivityAdapter(mContext, mTodayActivityList);
        todayRecyclerView.setAdapter(mAdapter);
        todayRecyclerView.setLayoutManager(MyManager);
        todayActivitySrl.setColorSchemeColors(
                getResources().getColor(R.color.google_blue),
                getResources().getColor(R.color.google_green),
                getResources().getColor(R.color.google_red),
                getResources().getColor(R.color.google_yellow));
        //设置是否自动修复
        todayRecyclerView.setHasFixedSize(true);
        todayRecyclerView.addItemDecoration(new SpaceItemDecoretion(12));

        TodayActivityBean bean = new TodayActivityBean();
        bean.setDatatime("2017年3月18日");
        bean.setImage(R.drawable.today_activity_default);
        bean.setTitle("小学生夏日游馆开始啦!");
        bean.setSign("快来凉爽一夏");
        bean.setPrice(35);
        for (int i=0;i<10;i++){
            mTodayActivityList.add(bean);
        }

    }

    @OnClick(R.id.phone_register_img_back)
    public void onClick() {
        MFGT.finish(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //ButterKnife.unbind(this);
    }
}
