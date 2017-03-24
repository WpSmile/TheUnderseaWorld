package com.qifeng.theunderseaworld.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;
import android.widget.TextView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.adapter.TuangouManagerAdapter;
import com.qifeng.theunderseaworld.bean.TuangouManagerBean;
import com.qifeng.theunderseaworld.utils.MFGT;
import com.qifeng.theunderseaworld.utils.StatusBarCompat;
import com.qifeng.theunderseaworld.view.SpaceItemDecoretion;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
* 团购管理页面
* */
public class TuangouManagerActivity extends AppCompatActivity {
    private final static String TAG = TuangouManagerActivity.class.getCanonicalName();
    TuangouManagerActivity mContext;

    @BindView(R.id.phone_register_txtTitle)
    TextView phoneRegisterTxtTitle;
    @BindView(R.id.tuangou_manager_recyclerView)
    RecyclerView tuangouManagerRecyclerView;

    LinearLayoutManager manager;
    ArrayList<TuangouManagerBean> list;
    TuangouManagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //API19以下用于沉侵式菜单栏
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_tuangou_manager);

        //API20以上
        if (Build.VERSION.SDK_INT>Build.VERSION_CODES.KITKAT){
            //沉侵
            StatusBarCompat.compat(this,getResources().getColor(R.color.bottom_blue));
        }
        ButterKnife.bind(this);
        mContext = this;
        initView();
    }

    private void initView() {
        phoneRegisterTxtTitle.setText("团购管理");
        list = new ArrayList<>();
        TuangouManagerBean bean = new TuangouManagerBean();
        bean.setPrice("￥35");
        bean.setImage(R.drawable.today_activity_default);
        bean.setTitle("海底世界老年票");
        bean.setSign("海底世界官方旗舰店");
        bean.setKuncun("(库存999)");

        for (int i = 0;i<10;i++){
            list.add(bean);
        }

        manager = new LinearLayoutManager(mContext);
        mAdapter = new TuangouManagerAdapter(list,mContext);

        tuangouManagerRecyclerView.setAdapter(mAdapter);
        tuangouManagerRecyclerView.setLayoutManager(manager);
        tuangouManagerRecyclerView.setHasFixedSize(true);
        tuangouManagerRecyclerView.addItemDecoration(new SpaceItemDecoretion(12));
    }

    @OnClick(R.id.phone_register_img_back)
    public void onViewClicked() {
        MFGT.finish(this);
    }
}
