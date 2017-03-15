package com.qifeng.theunderseaworld.utils;

import android.app.Activity;
import android.content.Intent;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.activity.MainActivity;

/**
 * Created by liu on 2017/3/15.
 */

public class MFGT {
    public static void finish(Activity activity){
        activity.finish();
        activity.overridePendingTransition(R.anim.push_right_in,R.anim.push_right_out);
    }
    public static void gotoMainAcvitity(Activity context){
        startActivity(context, MainActivity.class);
    }
    public static void startActivity(Activity context,Class<?> cls){
        Intent intent = new Intent();
        intent.setClass(context,cls);
        startActivity(context,intent);
    }
    public static void startActivity(Activity context,Intent intent){
        context.startActivity(intent);
        context.overridePendingTransition(R.anim.push_right_in,R.anim.push_right_out);
    }
}
