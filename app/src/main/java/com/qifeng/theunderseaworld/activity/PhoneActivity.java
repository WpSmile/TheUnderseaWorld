package com.qifeng.theunderseaworld.activity;

import android.content.Context;
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
import com.qifeng.theunderseaworld.view.CircleImageView;

/**
 * Created by XinAiXiaoWen on 2017/3/23.
 */

public class PhoneActivity extends BaseActivity implements View.OnClickListener{

    //输出日志
    private String TAG = PhoneActivity.class.getSimpleName();

    //上下文
    private Context phoneContext = null;

    //返回
    private ImageView ivSeabedPhoneReturn = null;

    //头像
    private CircleImageView civSeabedPhoneHead = null;

    //名称
    private TextView tvSeabedPhoneName = null;

    //国家/地区
    private TextView tvSeabedPhoneCountry = null;

    //手机号
    private EditText etSeabedPhoneNo = null;

    //发送验证码
    private TextView tvSeabedPhoneProving = null;

    //密码
    private EditText etSeabedPhoneVerify = null;

    //个人登录
    private TextView tvSeabedPhonePersonal = null;

    //商家登录
    private TextView tvSeabedPasswordShops = null;

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
        setContentView(R.layout.activity_phone);

        //API>=20以上用于沉侵式菜单栏
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            //沉侵
            StatusBarCompat.compat(this, getResources().getColor(R.color.seabed_item_mall_line));
        }

        //初始化前
        initPassWordAgo();

        //初始化控件
        initPassWordView();

        //注册监听
        initPassWordListener();

        //初始化后
        initPassWordBack();
    }

    /**
     * 初始化前
     */
    private void initPassWordAgo(){
        //上下文赋值
       phoneContext = this;
    }

    /**
     * 初始化控件
     */
    private void initPassWordView(){
        //返回
        ivSeabedPhoneReturn = (ImageView) this.findViewById(R.id.iv_seabed_phone_return);
        //头像
        civSeabedPhoneHead = (CircleImageView) this.findViewById(R.id.civ_seabed_phone_head);
        //名称
        tvSeabedPhoneName = (TextView) this.findViewById(R.id.tv_seabed_phone_name);
        //国家/地区
        tvSeabedPhoneCountry = (TextView) this.findViewById(R.id.tv_seabed_phone_country);
        //手机号
        etSeabedPhoneNo = (EditText) this.findViewById(R.id.et_seabed_phone_no);
        //发送验证码
        tvSeabedPhoneProving = (TextView) this.findViewById(R.id.tv_seabed_phone_proving);
        //密码
        etSeabedPhoneVerify = (EditText) this.findViewById(R.id.et_seabed_phone_verify);
        //个人登录
        tvSeabedPhonePersonal = (TextView) this.findViewById(R.id.tv_seabed_phone_personal);
        //商家登录
        tvSeabedPasswordShops = (TextView) this.findViewById(R.id.tv_seabed_phone_shops);
    }

    /**
     * 注册监听
     */
    private void initPassWordListener(){
        //返回注册监听
        ivSeabedPhoneReturn.setOnClickListener(this);
        //国家/地区注册监听
        tvSeabedPhoneCountry.setOnClickListener(this);
        //发送验证码注册监听
        tvSeabedPhoneProving.setOnClickListener(this);
        //个人登录
        tvSeabedPhonePersonal.setOnClickListener(this);
        //商家登录
        tvSeabedPasswordShops.setOnClickListener(this);
    }

    /**
     * 初始化后
     */
    private void initPassWordBack(){

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //返回
            case R.id.iv_seabed_phone_return:
                finish();
                break;
            //国家/地区
            case R.id.tv_seabed_phone_country:
                break;
            //发送验证码
            case R.id.tv_seabed_phone_proving:
                break;
            //个人登录
            case R.id.tv_seabed_phone_personal:
                break;
            //商家登录
            case R.id.tv_seabed_phone_shops:
                break;
        }
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
