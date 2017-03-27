package com.qifeng.theunderseaworld.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.UnderseaWorldApplication;
import com.qifeng.theunderseaworld.bean.User;
import com.qifeng.theunderseaworld.dao.SharePrefrenceUtils;
import com.qifeng.theunderseaworld.dao.UserDao;
import com.qifeng.theunderseaworld.utils.L;
import com.qifeng.theunderseaworld.utils.MFGT;

public class SplashActivity extends AppCompatActivity {
    private final long splashTime = 3000;
    SplashActivity mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);  //全屏
        mContext = this;
    }

    @Override
    protected void onStart() {
        super.onStart();
        boolean b = new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                //耗时操作
                long costTime = System.currentTimeMillis() - start;
                if (splashTime - costTime > 0) {
                    try {
                        //如果耗时操作的时间小于闪屏时间,线程延时
                        Thread.sleep(splashTime - costTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                User user = UnderseaWorldApplication.getUser();
                L.e("fulicenter,user="+user);
                String username = SharePrefrenceUtils.getInstance(mContext).getUser();
                L.e("fulicenter,username="+username);
                if (user==null&&username!=null){
                    UserDao dao = new UserDao(mContext);
                    user = dao.getUser(username);
                    L.e("database,user="+user);
                    if (user!=null){
                        UnderseaWorldApplication.setUser(user);
                    }
                }
                MFGT.gotoMainAcvitity(mContext);
                MFGT.finish(mContext);
            }
        }, splashTime);
    }
}
