package com.qifeng.theunderseaworld.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.adapter.PersonalAdapter;
import com.qifeng.theunderseaworld.fragment.PersonalDilogFragment;
import com.qifeng.theunderseaworld.seabed_state.BaseActivity;
import com.qifeng.theunderseaworld.seabed_state.SeabedState;
import com.qifeng.theunderseaworld.seabed_state.StatusBarCompat;
import com.qifeng.theunderseaworld.utils.MFGT;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 个人信息页面
 * Created by XinAiXiaoWen on 2017/3/20.
 */

public class PersonalActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    //输出日志
    private String TAG = PersonalActivity.class.getSimpleName();

    //activity与activity逻辑层
    private SeabedState seabedState = SeabedState.getSeabedState();

    //上下文
    private Context personalContext = null;

    //返回
    private ImageView ivSeabedPersonalReturn = null;

    //个人信息集合业
    private ListView lvSeabedPersonalList = null;

    //退出登录
    private TextView tvSeabedPersonalSignout = null;

    //适配器
    private PersonalAdapter personalAdapter = null;

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
        setContentView(R.layout.activity_personal);
        ButterKnife.bind(this);

        //API>=20以上用于沉侵式菜单栏
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            //沉侵
            StatusBarCompat.compat(this, getResources().getColor(R.color.seabed_item_mall_line));
        }

        //初始化前
        initPersonalAgo();

        //初始化控件
        initPersonalView();

        //注册监听器
        initPersonalListener();

        //适配器
        initPersonalAdapter();

        //初始化后
        initPersonalBack();
    }

    /**
     * 初始化前
     */
    private void initPersonalAgo() {
        //上下文
        personalContext = this;
        seabedState.personalInit();
    }

    /**
     * 初始化控件
     */
    private void initPersonalView() {
        //返回
        ivSeabedPersonalReturn = (ImageView) this.findViewById(R.id.iv_seabed_personal_return);
        //信息集合
        lvSeabedPersonalList = (ListView) this.findViewById(R.id.lv_seabed_personal_list);
        //退出登录
        tvSeabedPersonalSignout = (TextView) this.findViewById(R.id.tv_seabed_personal_signout);
    }

    /**
     * 注册监听器
     */
    private void initPersonalListener() {
        //返回注册监听
        ivSeabedPersonalReturn.setOnClickListener(this);
        //信息集合注册监听
        lvSeabedPersonalList.setOnItemClickListener(this);
        //退出登录注册监听
        tvSeabedPersonalSignout.setOnClickListener(this);

    }

    /**
     * 适配器
     */
    private void initPersonalAdapter() {
        //个人信息适配器
        personalAdapter = new PersonalAdapter(personalContext);
        //绑定适配器
        lvSeabedPersonalList.setAdapter(personalAdapter);
    }

    /**
     * 初始化后
     */
    private void initPersonalBack() {

    }

    /**
     * 跳转
     *
     * @param activity
     */
    private void initIntent(Class<?> activity) {
        //初始跳转
        Intent intent = new Intent(personalContext, activity);
        //跳转
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //返回
            case R.id.iv_seabed_personal_return:
                MFGT.finish(this);
                break;
            //退出登录
            case R.id.tv_seabed_personal_signout:
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            //头像
            case 0:
                PersonalDilogFragment personalDilogFragment = new PersonalDilogFragment();
                personalDilogFragment.show(getSupportFragmentManager(), "标题");
                break;
            //昵称设置
            case 1:
                initIntent(NickNameActivity.class);
                break;
            //绑定手机
            case 2:
                initIntent(DindingphoneActivity.class);
                break;
            //绑定微信
            case 3:
                initIntent(DindingWechatActivity.class);
                break;
            //绑定支付宝
            case 4:
                initIntent(DindingPayActivity.class);
                break;
            //收货地址
            case 5:
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
