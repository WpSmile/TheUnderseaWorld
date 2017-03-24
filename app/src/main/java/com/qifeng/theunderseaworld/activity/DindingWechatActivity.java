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
 * 绑定微信页面
 * Created by XinAiXiaoWen on 2017/3/20.
 */

public class DindingWechatActivity extends BaseActivity implements View.OnClickListener{

    //输出日志
    private String TAG = DindingWechatActivity.class.getSimpleName();

    //上下文
    private Context dindingWechatContext = null;

    //返回
    private ImageView ivSeabedDindingwechatReturn = null;

    //解绑
    private TextView tvSeabedDindingwechatPersonal = null;

    //微信帐号
    private EditText etSeabedDindingwechatAccount = null;

    //微信密码
    private EditText etSeabedDindingwechatPassword = null;

    //确定绑定
    private TextView tvSeabedDindingwechatConfirmed = null;

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
        setContentView(R.layout.activity_dindingwechat);

        //API>=20以上用于沉侵式菜单栏
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            //沉侵
            StatusBarCompat.compat(this, getResources().getColor(R.color.seabed_item_mall_line));
        }

        //初始化前
        initDindingWechatAgo();

        //初始化控件
        initDindingWechatView();

        //注册监听器
        initDindingWechatListener();

        //初始化后
        initDindingWechatBack();
    }

    /**
     * 初始化前
     */
    private void initDindingWechatAgo(){
        //上下文
        dindingWechatContext = this;
    }

    /**
     * 初始化控件
     */
    private void initDindingWechatView(){
        //返回
        ivSeabedDindingwechatReturn = (ImageView) this.findViewById(R.id.iv_seabed_dindingwechat_return);
        //解绑
        tvSeabedDindingwechatPersonal = (TextView) this.findViewById(R.id.tv_seabed_dindingwechat_personal);
        //微信帐号
        etSeabedDindingwechatAccount = (EditText) this.findViewById(R.id.et_seabed_dindingwechat_account);
        //微信密码
        etSeabedDindingwechatPassword = (EditText) this.findViewById(R.id.et_seabed_dindingwechat_password);
        //确定绑定
        tvSeabedDindingwechatConfirmed = (TextView) this.findViewById(R.id.tv_seabed_dindingwechat_confirmed);
    }

    /**
     *注册监听器
     */
    private void initDindingWechatListener(){
        //返回
        ivSeabedDindingwechatReturn.setOnClickListener(this);
        //解绑
        tvSeabedDindingwechatPersonal.setOnClickListener(this);
        //确定绑定注册监听器
        tvSeabedDindingwechatConfirmed.setOnClickListener(this);
    }

    /**
     * 初始化后
     */
    private void initDindingWechatBack(){

    }

    /**
     * 跳转
     * @param activity
     */
    private void initIntent(Class<?> activity){
        //初始跳转
        Intent intent = new Intent(dindingWechatContext,activity);
        //跳转
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //返回
            case R.id.iv_seabed_dindingwechat_return:
                finish();
                break;
            //解绑
            case R.id.tv_seabed_dindingwechat_personal:
                initIntent(UnbundlingWechatActivity.class);
                break;
            //确定绑定
            case R.id.tv_seabed_dindingwechat_confirmed:
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
