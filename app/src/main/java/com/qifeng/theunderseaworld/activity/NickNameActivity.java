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
 * 昵称设置界面
 * Created by XinAiXiaoWen on 2017/3/21.
 */

public class NickNameActivity extends BaseActivity implements View.OnClickListener{

    //输出日志
    private String TAG = NickNameActivity.class.getSimpleName();

    //activity与activity逻辑层
    private SeabedState seabedState = SeabedState.getSeabedState();

    //上下文
    private Context nickNameContext = null;

    //返回
    private ImageView ivSeabedNicknameReturn = null;

    //输入昵称框
    private EditText etSeabedNicknameInput = null;

    //保存
    private TextView tvSeabedNicknamePreser = null;

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
        setContentView(R.layout.activity_nickname);

        //API>=20以上用于沉侵式菜单栏
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            //沉侵
            StatusBarCompat.compat(this, getResources().getColor(R.color.seabed_item_mall_line));
        }

        //初始化前
        initNickNameAgo();

        //初始化控件
        initNickNameView();

        //注册监听
        initNickNameListener();

        //初始化后
        initNickNameBack();
    }

    /**
     * 初始化前
     */
    private void initNickNameAgo(){
        //上下文赋值
        nickNameContext = this;
    }

    /**
     * 初始化控件
     */
    private void initNickNameView(){
        //返回
        ivSeabedNicknameReturn = (ImageView) this.findViewById(R.id.iv_seabed_nickname_return);
        //输入框
        etSeabedNicknameInput = (EditText) this.findViewById(R.id.et_seabed_nickname_input);
        //保存
        tvSeabedNicknamePreser = (TextView) this.findViewById(R.id.tv_seabed_nickname_preser);
    }

    /**
     * 注册监听
     */
    private void initNickNameListener(){
        //返回注册监听
        ivSeabedNicknameReturn.setOnClickListener(this);
        //保存
        tvSeabedNicknamePreser.setOnClickListener(this);
    }

    /**
     * 初始化后
     */
    private void initNickNameBack(){

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //返回
            case R.id.iv_seabed_nickname_return:
                finish();
                break;
            //保存
            case R.id.tv_seabed_nickname_preser:
                seabedState.initToast(nickNameContext,"保存成功");
                finish();
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
