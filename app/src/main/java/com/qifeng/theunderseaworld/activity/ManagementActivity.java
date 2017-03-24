package com.qifeng.theunderseaworld.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.fragment.DepotFragment;
import com.qifeng.theunderseaworld.fragment.SellFragment;
import com.qifeng.theunderseaworld.seabed_state.BaseActivity;
import com.qifeng.theunderseaworld.seabed_state.StatusBarCompat;

/**
 * 商品管理
 * Created by XinAiXiaoWen on 2017/3/21.
 */

public class ManagementActivity extends BaseActivity implements View.OnClickListener {

    //输出日志
    private String TAG = ManagementActivity.class.getSimpleName();

    //上下文
    private Context managementContext = null;

    //返回
    private ImageView ivSeabedShelvesReturn = null;

    //发布
    private TextView tvSeabedShelvesRelease = null;

    //销售中
    private TextView tvSeabedManagementSell = null;

    //仓库中
    private TextView tvSeabedManagementDepot = null;

    //放置Fragment所用
    private FrameLayout flSeabedManagementFragment = null;

    //销售中
    private SellFragment sellFragment = null;

    //仓库中
    private DepotFragment depotFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //去掉标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //API19以下用于沉侵式菜单栏
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        //加载布局
        setContentView(R.layout.activity_management);

        //API>=20以上用于沉侵式菜单栏
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            //沉侵
            StatusBarCompat.compat(this, getResources().getColor(R.color.seabed_item_mall_line));
        }

        //初始化前
        initManagementAgo();

        //初始化控件
        initManagementView();

        //初始化注册监听
        initManagementListener();

        //初始化后
        initManagementBack();
    }

    /**
     * 初始化前
     */
    private void initManagementAgo() {
        managementContext = this;
    }

    /**
     * 初始化控件
     */
    private void initManagementView() {
        //返回
        ivSeabedShelvesReturn = (ImageView) this.findViewById(R.id.iv_seabed_shelves_return);
        //发布
        tvSeabedShelvesRelease = (TextView) this.findViewById(R.id.tv_seabed_shelves_release);
        //销售中
        tvSeabedManagementSell = (TextView) this.findViewById(R.id.tv_seabed_management_sell);
        //仓库中
        tvSeabedManagementDepot = (TextView) this.findViewById(R.id.tv_seabed_management_depot);
        //放置Fragment所用
        flSeabedManagementFragment = (FrameLayout) this.findViewById(R.id.fl_seabed_management_fragment);
    }

    /**
     * 初始化注册监听
     */
    private void initManagementListener() {
        //返回
        ivSeabedShelvesReturn.setOnClickListener(this);
        //发布
        tvSeabedShelvesRelease.setOnClickListener(this);
        //销售中
        tvSeabedManagementSell.setOnClickListener(this);
        //仓库中
        tvSeabedManagementDepot.setOnClickListener(this);
    }

    /**
     * 初始化后
     */
    private void initManagementBack() {
        //绑定fragment
        defaultFragment();
    }

    /**
     * 绑定fragment
     */
    private void defaultFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        sellFragment = new SellFragment();
        transaction.replace(R.id.fl_seabed_management_fragment, sellFragment);
        transaction.commit();
    }

    /**
     * 跳转
     * @param activity
     */
    private void initIntent(Class<?> activity){
        //初始跳转
        Intent intent = new Intent(managementContext,activity);
        //跳转
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        switch (v.getId()) {
            //返回
            case R.id.iv_seabed_shelves_return:
                break;
            //发布
            case R.id.tv_seabed_shelves_release:
                initIntent(ShelvesActivity.class);
                break;
            //销售中
            case R.id.tv_seabed_management_sell:
                tvSeabedManagementSell.setBackgroundColor(managementContext.getResources().getColor(R.color.white));
                tvSeabedManagementDepot.setBackgroundColor(managementContext.getResources().getColor(R.color.seabed_item_mall_bak));
                if(sellFragment == null){
                    sellFragment = new SellFragment();
                }
                transaction.replace(R.id.fl_seabed_management_fragment, sellFragment);
                break;
            //仓库中
            case R.id.tv_seabed_management_depot:
                tvSeabedManagementSell.setBackgroundColor(managementContext.getResources().getColor(R.color.seabed_item_mall_bak));
                tvSeabedManagementDepot.setBackgroundColor(managementContext.getResources().getColor(R.color.white));
                if(depotFragment == null){
                    depotFragment = new DepotFragment();
                }
                transaction.replace(R.id.fl_seabed_management_fragment, depotFragment);
                break;
        }
        transaction.commit();
    }
}
