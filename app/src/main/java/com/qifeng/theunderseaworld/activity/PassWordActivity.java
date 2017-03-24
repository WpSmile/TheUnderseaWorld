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
import com.qifeng.theunderseaworld.seabed_state.SeabedState;
import com.qifeng.theunderseaworld.seabed_state.StatusBarCompat;

/**
 * 忘记密码界面
 * Created by XinAiXiaoWen on 2017/3/23.
 */

public class PassWordActivity extends BaseActivity implements View.OnClickListener{

    //输出日志
    private String TAG = PassWordActivity.class.getSimpleName();

    //activity与activity逻辑层
    private SeabedState seabedState = SeabedState.getSeabedState();

    //上下文
    private Context passWordContext = null;

    //返回
    private ImageView ivSeabedPasswordReturn = null;

    //手机号
    private EditText etSeabedPasswordPhone = null;

    //验证码
    private EditText etSeabedPasswordProving = null;

    //获取验证码
    private TextView tvSeabedPasswordGain = null;

    //新密码
    private EditText etSeabedPasswordNew = null;

    //确定
    private TextView tvSeabedPasswordConfirm = null;

    //已有账号登录
    private TextView tvSeabedPasswordAlready = null;

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
        setContentView(R.layout.activity_password);

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
        passWordContext = this;
    }

    /**
     * 初始化控件
     */
    private void initPassWordView(){
        //返回
        ivSeabedPasswordReturn = (ImageView) this.findViewById(R.id.iv_seabed_password_return);
        //手机号
        etSeabedPasswordPhone = (EditText) this.findViewById(R.id.et_seabed_password_phone);
        //验证码
        etSeabedPasswordProving = (EditText) this.findViewById(R.id.et_seabed_password_proving);
        //获取验证码
        tvSeabedPasswordGain = (TextView) this.findViewById(R.id.tv_seabed_password_gain);
        //新密码
        etSeabedPasswordNew = (EditText) this.findViewById(R.id.et_seabed_password_new);
        //确定
        tvSeabedPasswordConfirm = (TextView) this.findViewById(R.id.tv_seabed_password_confirm);
        //已有账号登录
        tvSeabedPasswordAlready = (TextView) this.findViewById(R.id.tv_seabed_password_already);
    }

    /**
     * 注册监听
     */
    private void initPassWordListener(){
        //返回
        ivSeabedPasswordReturn.setOnClickListener(this);
        //获取验证码
        tvSeabedPasswordGain.setOnClickListener(this);
        //确定
        tvSeabedPasswordConfirm.setOnClickListener(this);
        //已有账号登录
        tvSeabedPasswordAlready.setOnClickListener(this);
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
            case R.id.iv_seabed_password_return:
                finish();
                break;
            //获取验证码
            case R.id.tv_seabed_password_gain:
                break;
            //确定
            case R.id.tv_seabed_password_confirm:
                break;
            //已有账号登录
            case R.id.tv_seabed_password_already:
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
