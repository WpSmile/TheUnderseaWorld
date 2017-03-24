package com.qifeng.theunderseaworld.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.seabed_state.BaseActivity;
import com.qifeng.theunderseaworld.seabed_state.StatusBarCompat;

/**
 *解绑手机
 * Created by XinAiXiaoWen on 2017/3/21.
 */

public class UnbundlingphoneActivity extends BaseActivity implements View.OnClickListener{

    //输出日志所用
    private String TAG = UnbundlingphoneActivity.class.getSimpleName();

    //上下文
    private Context unbundlingphoneContext = null;

    //返回
    private ImageView ivSeabedUnbundlingphoneReturn = null;

    //取消
    private TextView tvSeabedDindingphoneCancel = null;

    //停用
    private TextView tvSeabedDindingphoneDisable = null;

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
        setContentView(R.layout.activity_unbundlingphone);

        //API>=20以上用于沉侵式菜单栏
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            //沉侵
            StatusBarCompat.compat(this, getResources().getColor(R.color.seabed_item_mall_line));
        }

        //初始化前
        initUnbundlingphoneAgo();

        //初始化控件
        initUnbundlingphoneView();

        //注册监听器
        initUnbundlingphoneListener();

        //初始化后
        initUnbundlingphoneBack();
    }

    /**
     * 初始化前
     */
    private void initUnbundlingphoneAgo(){
        //上下文
        unbundlingphoneContext = this;
    }

    /**
     * 初始化控件
     */
    private void initUnbundlingphoneView(){
        //返回
        ivSeabedUnbundlingphoneReturn = (ImageView) this.findViewById(R.id.iv_seabed_unbundlingphone_return);
        //取消
        tvSeabedDindingphoneCancel = (TextView) this.findViewById(R.id.tv_seabed_dindingphone_cancel);
        //停用
        tvSeabedDindingphoneDisable = (TextView) this.findViewById(R.id.tv_seabed_dindingphone_disable);
    }

    /**
     * 注册监听器
     */
    private void initUnbundlingphoneListener(){
        //返回注册监听器
        ivSeabedUnbundlingphoneReturn.setOnClickListener(this);
        //取消
        tvSeabedDindingphoneCancel.setOnClickListener(this);
        //停用
        tvSeabedDindingphoneDisable.setOnClickListener(this);
    }

    /**
     * 初始化后
     */
    private void initUnbundlingphoneBack(){

    }

    /**
     * 响应事件
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //返回
            case R.id.iv_seabed_unbundlingphone_return:
                finish();
                break;
            //取消
            case R.id.tv_seabed_dindingphone_cancel:
                finish();
                break;
            //停用
            case R.id.tv_seabed_dindingphone_disable:
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
