package com.qifeng.theunderseaworld.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;

import com.qifeng.theunderseaworld.I;
import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.activity.AnimalKePuActivity;
import com.qifeng.theunderseaworld.activity.ApplyRefundActivity;
import com.qifeng.theunderseaworld.activity.CartActivity;
import com.qifeng.theunderseaworld.activity.CommentActivity;
import com.qifeng.theunderseaworld.activity.ForgetPasswordActivity;
import com.qifeng.theunderseaworld.activity.HotRecommondActivity;
import com.qifeng.theunderseaworld.activity.IntroduceActivity;
import com.qifeng.theunderseaworld.activity.MainActivity;
import com.qifeng.theunderseaworld.activity.MapActivity;
import com.qifeng.theunderseaworld.activity.OrderManageBusinessActivity;
import com.qifeng.theunderseaworld.activity.OrderManagementActivity;
import com.qifeng.theunderseaworld.activity.PaySystemActivity;
import com.qifeng.theunderseaworld.activity.PaySystemBusinessActivity;
import com.qifeng.theunderseaworld.activity.PingjiaSystemActivity;
import com.qifeng.theunderseaworld.activity.PingjiaSystemBusinessActivity;
import com.qifeng.theunderseaworld.activity.RegisterByPhoneActivity;
import com.qifeng.theunderseaworld.activity.ReplyActivity;
import com.qifeng.theunderseaworld.activity.TodayActivity;
import com.qifeng.theunderseaworld.activity.TuangouManagerActivity;
import com.qifeng.theunderseaworld.activity.YuEActivity;

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

    public static void gotoCartActivity(MainActivity context) {
        startActivity(context, CartActivity.class);
    }

    public static void gotoPersonalInfoActivity(MainActivity context) {
        //startActivity(context,PersonalInfoActivity.class);
    }

    public static void gotoOrderManagementActivity(MainActivity context) {
        startActivity(context, OrderManagementActivity.class);
    }
    public static void gotoOrderManageBusinessActivity(MainActivity context) {
        startActivity(context, OrderManageBusinessActivity.class);
    }

    public static void gotoPaySystemActivity(MainActivity context) {
        startActivity(context, PaySystemActivity.class);
    }

    public static void gotoYuEActivity(MainActivity context) {
        startActivity(context, YuEActivity.class);
    }

    public static void gotoPingjiaSystemActivity(MainActivity context) {
        startActivity(context, PingjiaSystemActivity.class);
    }

    public static void gotoPingjiaSystemBusinessActivity(MainActivity context) {
        startActivity(context, PingjiaSystemBusinessActivity.class);
    }

    public static void gotoCommentActivity(Context context) {
        Intent intent = new Intent();
        intent.setClass(context,CommentActivity.class);
        context.startActivity(intent);
    }

    public static void gotoApplyRefundActivity(Context mContext) {
        Intent intent = new Intent();
        intent.setClass(mContext,ApplyRefundActivity.class);
        mContext.startActivity(intent);
    }

    public static void gotoTuangouManagerActivity(MainActivity mContext) {
        Intent intent = new Intent();
        intent.setClass(mContext,TuangouManagerActivity.class);
        mContext.startActivity(intent);
    }

    public static void gotoReplyActivity(Context context) {
        Intent intent = new Intent();
        intent.setClass(context,ReplyActivity.class);
        context.startActivity(intent);
    }

    public static void gotoPaySystemBusinessActivity(MainActivity context) {
        startActivity(context, PaySystemBusinessActivity.class);
    }
}
