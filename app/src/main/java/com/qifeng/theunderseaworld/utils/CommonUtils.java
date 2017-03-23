package com.qifeng.theunderseaworld.utils;

import android.content.Context;
import android.widget.Toast;

import com.qifeng.theunderseaworld.UnderseaWorldApplication;


public class CommonUtils {
    public static void showLongToast(String msg){
        Toast.makeText(UnderseaWorldApplication.getInstance(),msg,Toast.LENGTH_LONG).show();
    }
    public static void showShortToast(String msg){
        Toast.makeText(UnderseaWorldApplication.getInstance(),msg,Toast.LENGTH_SHORT).show();
    }
    public static void showLongToast(int rId){
        showLongToast(UnderseaWorldApplication.getInstance().getString(rId));
    }
    public static void showShortToast(int rId){
        showShortToast(UnderseaWorldApplication.getInstance().getString(rId));
    }
}
