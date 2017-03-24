package com.qifeng.theunderseaworld.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.seabed_state.BaseActivity;
import com.qifeng.theunderseaworld.seabed_state.StatusBarCompat;

/**
 * 支付宝页面
 * Created by XinAiXiaoWen on 2017/3/20.
 */

public class DindingPayActivity extends BaseActivity implements View.OnClickListener{

    //输出日志所用
    private String TAG = DindingPayActivity.class.getSimpleName();

    //上下文
    private Context dindingPayContext = null;

    //返回
    private ImageView ivSeabedDindingpayReturn = null;

    //解绑
    private TextView tvSeabedDindingpayPersonal = null;

    //支付宝账号
    private EditText etSeabedDindingpayAccount = null;

    //支付宝密码
    private EditText etSeabedDindingpayPassword = null;

    //确定绑定
    private TextView tvSeabedDindingpayConfirmed = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //API19以下用于沉侵式菜单栏
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        //加载布局
        setContentView(R.layout.activity_dindingpay);

        //API>=20以上用于沉侵式菜单栏
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            //沉侵
            StatusBarCompat.compat(this, getResources().getColor(R.color.seabed_item_mall_line));
        }

        //初始化前
        initDindingPayAgo();

        //初始化控件
        initDindingPayView();

        //初始化监听器
        initDindingPayListener();

        //初始化后
        initDindingPayBack();
    }

    /**
     * 初始化前
     */
    private void initDindingPayAgo(){
        dindingPayContext = this;
    }

    /**
     * 初始化控件
     */
    private void initDindingPayView(){
        //返回
        ivSeabedDindingpayReturn = (ImageView) this.findViewById(R.id.iv_seabed_dindingpay_return);
        //解绑
        tvSeabedDindingpayPersonal = (TextView) this.findViewById(R.id.tv_seabed_dindingpay_personal);
        //支付宝账号
        etSeabedDindingpayAccount = (EditText) this.findViewById(R.id.et_seabed_dindingpay_account);
        //支付宝密码
        etSeabedDindingpayPassword = (EditText) this.findViewById(R.id.et_seabed_dindingpay_password);
        //确定绑定
        tvSeabedDindingpayConfirmed = (TextView) this.findViewById(R.id.tv_seabed_dindingpay_confirmed);
    }

    /**
     * 注册监听器
     */
    private void initDindingPayListener(){
        //返回注册监听
        ivSeabedDindingpayReturn.setOnClickListener(this);
        //解绑注册监听
        tvSeabedDindingpayPersonal.setOnClickListener(this);
        //确定绑定监听
        tvSeabedDindingpayConfirmed.setOnClickListener(this);
    }

    /**
     * 初始化后
     */
    private void initDindingPayBack(){

    }

    /**
     * 跳转
     * @param activity
     */
    private void initIntent(Class<?> activity){
        //初始跳转
        Intent intent = new Intent(dindingPayContext,activity);
        //跳转
        startActivity(intent);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //返回
            case R.id.iv_seabed_dindingpay_return:
                finish();
                break;
            //解绑
            case R.id.tv_seabed_dindingpay_personal:
                initIntent(UnbundlingPayActivity.class);
                break;
            case R.id.tv_seabed_dindingpay_confirmed:
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "---启动---");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "---恢复---");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "---暂停---");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "---停止---");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "---重启---");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "---销毁---");
    }
}
