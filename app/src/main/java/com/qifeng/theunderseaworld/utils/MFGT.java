package com.qifeng.theunderseaworld.utils;

import android.app.Activity;
import android.content.Intent;

import com.qifeng.theunderseaworld.I;
import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.activity.AnimalKePuActivity;
import com.qifeng.theunderseaworld.activity.ForgetPasswordActivity;
import com.qifeng.theunderseaworld.activity.HotRecommondActivity;
import com.qifeng.theunderseaworld.activity.IntroduceActivity;
import com.qifeng.theunderseaworld.activity.MainActivity;
import com.qifeng.theunderseaworld.activity.MapActivity;
import com.qifeng.theunderseaworld.activity.RegisterByPhoneActivity;
import com.qifeng.theunderseaworld.activity.TodayActivity;

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
        Intent intent = new Intent(context,cls);
        context.startActivity(intent);
        context.overridePendingTransition(R.anim.push_right_in,R.anim.push_right_out);
    }
    public static void gotoRegisterByPhoneActivity(Activity context){
        startActivity(context,RegisterByPhoneActivity.class);
    }
    public static void startActivityForResult(Activity context,Intent intent,int requestCode){
        context.startActivityForResult(intent,requestCode);
        context.overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
    }
    public static void gotoMapActivity(Activity context){
        startActivity(context, MapActivity.class);
    }
    public static void gotoIntroduceActivity(Activity context){
        startActivity(context, IntroduceActivity.class);
    }
    public static void gotoTodayActivity(Activity context){
        startActivity(context,TodayActivity.class);
    }
    public static void gotoAnimalKePuActivity(Activity context){
        startActivity(context,AnimalKePuActivity.class);
    }
    public static void gotoHotRecommondActivity(Activity context){
        startActivity(context,HotRecommondActivity.class);
    }
    public static void gotoForgetPasswordActivity(Activity context){
        startActivity(context, ForgetPasswordActivity.class);
    }
}
