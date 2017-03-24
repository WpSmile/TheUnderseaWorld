package com.qifeng.theunderseaworld.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.seabed_state.BaseActivity;
import com.qifeng.theunderseaworld.seabed_state.StatusBarCompat;

/**
 * 新增地址页面
 * Created by XinAiXiaoWen on 2017/3/21.
 */

public class NewlyaddedActivity extends BaseActivity implements View.OnClickListener{

    private String TAG = NewlyaddedActivity.class.getSimpleName();

    private Context newlyaddedContext = null;

    private ImageView ivSeabedNewlyaddedReturn = null;

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
        setContentView(R.layout.activity_newlyadded);

        //API>=20以上用于沉侵式菜单栏
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            //沉侵
            StatusBarCompat.compat(this, getResources().getColor(R.color.colorPrimary));
        }

        initNewlyaddedAgo();

        initNewlyaddedView();

        initNewlyaddedListener();

        initNewlyaddedBack();
    }

    private void initNewlyaddedAgo(){
        newlyaddedContext = this;
    }

    private void initNewlyaddedView(){
        ivSeabedNewlyaddedReturn = (ImageView) this.findViewById(R.id.iv_seabed_newlyadded_return);
    }

    private void initNewlyaddedListener(){
        ivSeabedNewlyaddedReturn.setOnClickListener(this);
    }

    private void initNewlyaddedBack(){

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.iv_seabed_newlyadded_return:
                break;
        }
    }
}
