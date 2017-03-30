package com.qifeng.theunderseaworld.dao;


import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016/10/24.
 */
public class SharePrefrenceUtils {
    private static final String SHARE_NAME = "saveUserInfo";
    private static SharePrefrenceUtils instance;
    private static final String SHARE_KEY_USER_ID = "share_key_user_id";
    private static final String SHARE_KEY_USER_NAME = "share_key_user_name";
    private static final String SHARE_KEY_USER_MOBILE = "share_key_user_mobile";
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;


    public SharePrefrenceUtils(Context context){
        mSharedPreferences = context.getSharedPreferences(SHARE_NAME,Context.MODE_PRIVATE);
        mEditor =mSharedPreferences.edit();
    }
    public static SharePrefrenceUtils getInstance(Context context){
        if (instance==null){
            instance = new SharePrefrenceUtils(context);
        }
        return instance;
    }

    public void saveUser(String username){
        mEditor.putString(SHARE_KEY_USER_NAME,username);
        mEditor.commit();
    }

    public String getUser(){
        return mSharedPreferences.getString(SHARE_KEY_USER_NAME,null);
    }

    public void removeUser(){
        mEditor.remove(SHARE_KEY_USER_NAME);
        mEditor.commit();
    }
}
