package com.qifeng.theunderseaworld;

import android.app.Application;

import com.qifeng.theunderseaworld.bean.User;



/**
 * Created by Administrator on 2016/10/17.
 */
public class UnderseaWorldApplication extends Application {
    private static UnderseaWorldApplication instance;
    public static UnderseaWorldApplication application;

    public static String userName;
    private static User user;

    public static String usersign;//用于判断用户身份的标识

    public static String getUsersign() {
        return usersign;
    }

    public static void setUsersign(String usersign) {
        UnderseaWorldApplication.usersign = usersign;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        UnderseaWorldApplication.user = user;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        UnderseaWorldApplication.userName = userName;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        instance = this;
    }


    public static UnderseaWorldApplication getInstance() {

        if (instance == null) {
            instance = new UnderseaWorldApplication();
        }
        return instance;
    }
}
