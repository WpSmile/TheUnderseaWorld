package com.qifeng.theunderseaworld.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.utils.MFGT;
import com.qifeng.theunderseaworld.utils.StatusBarCompat;
import com.qifeng.theunderseaworld.view.FlowIndicator;
import com.qifeng.theunderseaworld.view.SlideAutoLoopView;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimalKePuActivity extends AppCompatActivity {
    SlideAutoLoopView slideAutoLoopView;
    FlowIndicator flowIndicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //API19以下用于沉侵式菜单栏
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_animal_ke_pu);
        //API20以上
        if (Build.VERSION.SDK_INT>Build.VERSION_CODES.KITKAT){
            //沉侵
            StatusBarCompat.compat(this,getResources().getColor(R.color.bottom_blue));
        }
        ButterKnife.bind(this);

        initView();
        initData();
    }

    private void initData() {
        String[] imageurl = {"miku.jpg", "wusaki.jpg", "%CE%BC%27s.jpg", "project.jpg"};

        slideAutoLoopView.startPlayLoop(flowIndicator, imageurl, imageurl.length);
    }

    private void initView() {
        slideAutoLoopView = (SlideAutoLoopView) findViewById(R.id.kepu_slideAuto);
        flowIndicator = (FlowIndicator) findViewById(R.id.kepu_flowIndicator);
    }

    @OnClick(R.id.kepu_img_back)
    public void onClick() {
        MFGT.finish(this);
    }
}
