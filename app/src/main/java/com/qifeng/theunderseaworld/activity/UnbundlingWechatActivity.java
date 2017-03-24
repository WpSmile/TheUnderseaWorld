package com.qifeng.theunderseaworld.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.apkfuns.xprogressdialog.XProgressDialog;
import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.seabed_state.BaseActivity;
import com.qifeng.theunderseaworld.seabed_state.StatusBarCompat;

/**
 * 解绑微信
 * Created by XinAiXiaoWen on 2017/3/21.
 */

public class UnbundlingWechatActivity extends BaseActivity implements View.OnClickListener {

    //输出日志
    private String TAG = UnbundlingWechatActivity.class.getSimpleName();

    //上下文
    private Context unbundlingWechatContext = null;

    //返回
    private ImageView ivSseabedUnbundlingwechatReturn = null;

    //解绑
    private TextView tvSeabedUnbundlingwechatRelieve = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //API19以下用于沉侵式菜单栏
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        //加载布局
        setContentView(R.layout.activity_unbundlingwechat);

        //API>=20以上用于沉侵式菜单栏
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            //沉侵
            StatusBarCompat.compat(this, getResources().getColor(R.color.seabed_item_mall_line));
        }

        //初始化前
        initUnbundlingWechatAgo();

        //初始化控件
        initUnbundlingWechatView();

        //注册监听器
        initUnbundlingWechatListener();

        //初始化后
        initUnbundlingWechatBack();
    }

    /**
     * 初始化前
     */
    private void initUnbundlingWechatAgo() {
        unbundlingWechatContext = this;
    }

    /**
     * 初始化控件
     */
    private void initUnbundlingWechatView() {
        //返回
        ivSseabedUnbundlingwechatReturn = (ImageView) this.findViewById(R.id.iv_seabed_unbundlingwechat_return);
        //解绑
        tvSeabedUnbundlingwechatRelieve = (TextView) this.findViewById(R.id.tv_seabed_unbundlingwechat_relieve);
    }

    /**
     * 注册监听器
     */
    private void initUnbundlingWechatListener() {
        //返回
        ivSseabedUnbundlingwechatReturn.setOnClickListener(this);
        //解绑
        tvSeabedUnbundlingwechatRelieve.setOnClickListener(this);
    }

    /**
     * 初始化后
     */
    private void initUnbundlingWechatBack() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //返回
            case R.id.iv_seabed_unbundlingwechat_return:
                finish();
                break;
            //开始解绑
            case R.id.tv_seabed_unbundlingwechat_relieve:
                final XProgressDialog xProgressDialog = new XProgressDialog(unbundlingWechatContext, "解绑中");
                xProgressDialog.show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        xProgressDialog.cancel();
                    }
                }, 4000);
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "---启动---");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "---恢复---");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "---暂停---");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "---停止---");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "---重启---");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "---销毁---");
    }
}
