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

/**
 * 宝贝上架
 * Created by XinAiXiaoWen on 2017/3/21.
 */

public class ShelvesActivity extends BaseActivity implements View.OnClickListener{

    //输出日志
    private String TAG = ShelvesActivity.class.getSimpleName();

    //上下文
    private Context shelvesContext = null;

    //返回
    private ImageView ivSeabedShelvesReturn = null;

    //相机
    private ImageView ivSeabedShelvesCamera = null;

    //商品名称
    private EditText etSeabedShelvesName = null;

    //宝贝单价
    private EditText etSeabedShelvesPrice = null;

    //库存
    private EditText etSeabedShelvesStock = null;

    //宝贝描述
    private EditText etSeabedShelvesDepict = null;

    //立即发布
    private TextView tvSeabedShelvesRelease  = null;

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
        setContentView(R.layout.activity_shelves);

        //API>=20以上用于沉侵式菜单栏
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            //沉侵
            StatusBarCompat.compat(this, getResources().getColor(R.color.seabed_item_mall_line));
        }

        //初始化前
        initShelvesAgo();

        //初始化控件
        initShelvesView();

        //注册监听器
        initShelvesListener();

        //初始化后
        initShelvesBack();
    }

    /**
     * 初始化前
     */
    private void initShelvesAgo(){
        shelvesContext = this;
    }

    /**
     * 初始化控件
     */
    private void initShelvesView(){
        //返回
        ivSeabedShelvesReturn = (ImageView) this.findViewById(R.id.iv_seabed_shelves_return);
        //相机
        ivSeabedShelvesCamera = (ImageView) this.findViewById(R.id.iv_seabed_shelves_camera);
        //商品名称
        etSeabedShelvesName = (EditText) this.findViewById(R.id.et_seabed_shelves_name);
        //宝贝单价
        etSeabedShelvesPrice = (EditText) this.findViewById(R.id.et_seabed_shelves_price);
        //库存
        etSeabedShelvesStock = (EditText) this.findViewById(R.id.et_seabed_shelves_stock);
        //宝贝描述
        etSeabedShelvesDepict = (EditText) this.findViewById(R.id.et_seabed_shelves_depict);
        //立即发布
        tvSeabedShelvesRelease = (TextView) this.findViewById(R.id.tv_seabed_shelves_release);
    }

    /**
     * 注册监听器
     */
    private void initShelvesListener(){
        //返回注册监听
        ivSeabedShelvesReturn.setOnClickListener(this);
        //相机
        ivSeabedShelvesCamera.setOnClickListener(this);
        //立即发布
        tvSeabedShelvesRelease.setOnClickListener(this);
    }

    /**
     * 初始化后
     */
    private void initShelvesBack(){

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //返回
            case R.id.iv_seabed_shelves_return:
                finish();
                break;
            //相机
            case R.id.iv_seabed_shelves_camera:
                break;
            //立即发布
            case R.id.tv_seabed_shelves_release:
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
