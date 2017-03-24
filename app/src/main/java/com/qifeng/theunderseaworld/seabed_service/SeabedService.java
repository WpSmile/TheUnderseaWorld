package com.qifeng.theunderseaworld.seabed_service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * 后台管理
 * Created by XinAiXiaoWen on 2017/3/23.
 */

public class SeabedService extends Service {

    //输出日志所用
    private String TAG = SeabedService.class.getSimpleName();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG,"---创建---");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"---销毁---");
    }

    /**
     * 返回服务
     */
    class SeabedIbinder extends Binder {
        public Service getService() {
            return SeabedService.this;
        }
    }
}
