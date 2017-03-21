package com.qifeng.theunderseaworld.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.UnderseaWorldApplication;
import com.qifeng.theunderseaworld.bean.User;

/*评价系统页面：根据登录的是用户还是商家的信息选择相应的item布局*/
public class PingjiaSystemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pingjia_system);

        //initView();
    }

    private void initView() {
        //获取登录时的任务信息
        User user = UnderseaWorldApplication.getUser();
        String nick = user.getMuserNick();
        if ("顾客".equals(nick)){//如果是顾客
            /*调用顾客的adapter并在里面设置相应的item*/
        }else {//如果是商家
            /*调用商家的adapter并在里面设置相应的item*/
        }
    }
}
