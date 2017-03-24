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
import com.qifeng.theunderseaworld.seabed_state.SeabedState;
import com.qifeng.theunderseaworld.seabed_state.StatusBarCompat;

/**
 * 绑定手机
 * Created by XinAiXiaoWen on 2017/3/20.
 */

public class DindingphoneActivity extends BaseActivity implements View.OnClickListener {

    //输出日志所用
    private String TAG = DindingphoneActivity.class.getSimpleName();

    //activity和activity的逻辑层
    private SeabedState seabedState = SeabedState.getSeabedState();

    //上下文
    private Context dindingphoneContext = null;

    //返回
    private ImageView ivSeabedDindingphoneReturn = null;

    //解绑
    private TextView tvSeabedDindingphonePersonal = null;

    //国家/地区
    private TextView tvSeabedDindingphoneCountry = null;

    //手机号
    private EditText etSeabedDindingphoneNo = null;

    //发送验证码
    private TextView tvSeabedDindingphoneProving = null;

    //验证码
    private TextView ivSeabedDindingphoneVerify = null;

    //完成
    private TextView tvSeabedDindingphoneComplete = null;

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
        setContentView(R.layout.activity_dindingphone);

        //API>=20以上用于沉侵式菜单栏
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            //沉侵
            StatusBarCompat.compat(this, getResources().getColor(R.color.seabed_item_mall_line));
        }

        //初始化前
        initDindingphoneAgo();

        //初始化控件
        initDindingphonView();

        //注册监听器
        initDindingphonListener();

        //初始化后
        initDindingphonBack();
    }

    /**
     * 初始化前
     */
    private void initDindingphoneAgo() {
        //上下文
        dindingphoneContext = this;
    }

    /**
     * 初始化控件
     */
    private void initDindingphonView() {
        //返回
        ivSeabedDindingphoneReturn = (ImageView) this.findViewById(R.id.iv_seabed_dindingphone_return);
        //解绑
        tvSeabedDindingphonePersonal = (TextView) this.findViewById(R.id.tv_seabed_dindingphone_personal);
        //国家和地区
        tvSeabedDindingphoneCountry = (TextView) this.findViewById(R.id.tv_seabed_dindingphone_country);
        //手机号
        etSeabedDindingphoneNo = (EditText) this.findViewById(R.id.et_seabed_dindingphone_no);
        //发送验证码
        tvSeabedDindingphoneProving = (TextView) this.findViewById(R.id.tv_seabed_dindingphone_proving);
        //验证码
        ivSeabedDindingphoneVerify = (TextView) this.findViewById(R.id.iv_seabed_dindingphone_verify);
        //完成
        tvSeabedDindingphoneComplete = (TextView) this.findViewById(R.id.tv_seabed_dindingphone_complete);
    }

    /**
     * 注册监听器
     */
    private void initDindingphonListener() {
        //返回注册监听
        ivSeabedDindingphoneReturn.setOnClickListener(this);
        //解绑注册监听
        tvSeabedDindingphonePersonal.setOnClickListener(this);
        //国家和地区
        tvSeabedDindingphoneCountry.setOnClickListener(this);
        //发送验证码
        tvSeabedDindingphoneProving.setOnClickListener(this);
        //验证码
        ivSeabedDindingphoneVerify.setOnClickListener(this);
        //完成
        tvSeabedDindingphoneComplete.setOnClickListener(this);
    }

    /**
     * 初始化后
     */
    private void initDindingphonBack() {

    }

    /**
     * 跳转
     * @param acitivity
     */
    private void initIntent(Class<?> acitivity){
        Intent intent = new Intent(dindingphoneContext,acitivity);
        startActivity(intent);
    }

    /**
     * 响应事件
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //返回
            case R.id.iv_seabed_dindingphone_return:
                finish();
                break;
            //解绑
            case R.id.tv_seabed_dindingphone_personal:
                initIntent(UnbundlingphoneActivity.class);
                break;
            //国家/地区
            case R.id.tv_seabed_dindingphone_country:
                initIntent(CountryActivity.class);
                break;
            //发送验证码
            case R.id.tv_seabed_dindingphone_proving:
                break;
            //完成
            case R.id.tv_seabed_dindingphone_complete:
                finish();
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
