package com.qifeng.theunderseaworld.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.apkfuns.xprogressdialog.XProgressDialog;
import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.seabed_state.BaseActivity;
import com.qifeng.theunderseaworld.seabed_state.StatusBarCompat;

/**
 * 解绑支付宝
 * Created by XinAiXiaoWen on 2017/3/21.
 */

public class UnbundlingPayActivity extends BaseActivity implements View.OnClickListener{

    //输出日志
    private String TAG = UnbundlingPayActivity.class.getSimpleName();

    //上下文
    private Context unbundlingContext = null;

    //返回
    private ImageView ivSeabedUnbundlingdingpayReturn = null;

    //支付宝账号
    private EditText etSeabedUnbundlingdingpayAccount = null;

    //支付宝密码
    private EditText etSeabedUnbundlingdingpayPassword = null;

    //确定解绑
    private TextView tvSeabedUnbundlingdingpayConfirmed = null;

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
        setContentView(R.layout.activity_unbundlingpay);

        //API>=20以上用于沉侵式菜单栏
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            //沉侵
            StatusBarCompat.compat(this, getResources().getColor(R.color.seabed_item_mall_line));
        }

        //初始化前
        initUnbundlingPayAgo();

        //初始化控件
        initUnbundlingPayView();

        //初始化监听器
        initUnbundlingPayListener();

        //初始化后
        initUnbundlingPayBack();
    }

    /**
     * 初始化前
     */
    private void initUnbundlingPayAgo(){
        //上下文
        unbundlingContext = this;
    }

    /**
     * 初始化控件
     */
    private void initUnbundlingPayView(){
        //返回
        ivSeabedUnbundlingdingpayReturn = (ImageView) this.findViewById(R.id.iv_seabed_unbundlingdingpay_return);
        //支付宝账号
        etSeabedUnbundlingdingpayAccount = (EditText) this.findViewById(R.id.et_seabed_unbundlingdingpay_account);
        //支付宝密码
        etSeabedUnbundlingdingpayPassword = (EditText) this.findViewById(R.id.et_seabed_unbundlingdingpay_password);
        //确定解绑
        tvSeabedUnbundlingdingpayConfirmed = (TextView) this.findViewById(R.id.tv_seabed_unbundlingdingpay_confirmed);
    }

    /**
     * 初始化监听器
     */
    private void initUnbundlingPayListener(){
        //返回
        ivSeabedUnbundlingdingpayReturn.setOnClickListener(this);
        //确定解绑
        tvSeabedUnbundlingdingpayConfirmed.setOnClickListener(this);
    }

    /**
     * 初始化后
     */
    private void initUnbundlingPayBack(){

    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            //返回
            case R.id.iv_seabed_unbundlingdingpay_return:
                finish();
                break;
            //确定解绑
            case R.id.tv_seabed_unbundlingdingpay_confirmed:
                final XProgressDialog xProgressDialog = new XProgressDialog(unbundlingContext, "解绑中");
                xProgressDialog.show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        xProgressDialog.cancel();
                    }
                }, 4000);
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
