package com.qifeng.theunderseaworld.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.qifeng.theunderseaworld.R;

public class SplashActivity extends AppCompatActivity {
    private final long splashTime = 2000;
    SplashActivity mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mContext = this;
    }

    @Override
    protected void onStart() {
        super.onStart();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                //耗时操作
                long costTime = System.currentTimeMillis()-start;
                if(splashTime-costTime>0){
                    try {
                        //如果耗时操作的时间小于闪屏时间,线程延时
                        Thread.sleep(splashTime-costTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },splashTime);
    }
}
