package com.qifeng.theunderseaworld.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.adapter.SectionsPagerAdapter;
import com.qifeng.theunderseaworld.fragment.CommunityFragment;
import com.qifeng.theunderseaworld.fragment.HomePageFragment;
import com.qifeng.theunderseaworld.fragment.PersonalBusinessFragment;
import com.qifeng.theunderseaworld.fragment.PersonalFragment;
import com.qifeng.theunderseaworld.fragment.PersonalUnloginFragment;
import com.qifeng.theunderseaworld.fragment.StoreFragment;
import com.qifeng.theunderseaworld.utils.StatusBarCompat;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener, ViewPager.OnPageChangeListener {
    private final static String TAG = MainActivity.class.getCanonicalName();

    @BindView(R.id.layViewPager)
    ViewPager layViewPager;
    private ArrayList<Fragment> fragments;
    private ViewPager viewPager;
    private BottomNavigationBar bottomNavigationBar;

    MyReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //API19以下用于沉侵式菜单栏
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_main);

        //API20以上
        if (Build.VERSION.SDK_INT>Build.VERSION_CODES.KITKAT){
            //沉侵
            StatusBarCompat.compat(this,getResources().getColor(R.color.bottom_blue));
        }
        ButterKnife.bind(this);

        myReceiver = new MyReceiver();
        initView();

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    private void addItem() {
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setTabSelectedListener(this);
        bottomNavigationBar.clearAll();
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .setBarBackgroundColor(R.color.bottom_blue);

        bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.shouye, R.string.home_page)
                .setInActiveColor(R.color.black)
                .setActiveColorResource(R.color.vertical_line))
                .addItem(new BottomNavigationItem(R.mipmap.shangcheng, R.string.store)
                        .setInActiveColor(R.color.black)
                        .setActiveColorResource(R.color.vertical_line))
                .addItem(new BottomNavigationItem(R.mipmap.shequ, R.string.community)
                        .setInActiveColor(R.color.black)
                        .setActiveColorResource(R.color.vertical_line))
                .addItem(new BottomNavigationItem(R.mipmap.wode, R.string.personal)
                        .setInActiveColor(R.color.black)
                        .setActiveColorResource(R.color.vertical_line))
                .setFirstSelectedPosition(0)
                .initialise();

    }

    private void initView() {
        //用于添加底部菜单的方法
        addItem();
        initViewPager();
    }

    private void initViewPager() {

        viewPager = (ViewPager) findViewById(R.id.layViewPager);
        fragments = new ArrayList<>();
        fragments.add(new HomePageFragment());
        fragments.add(new StoreFragment());
        fragments.add(new PersonalBusinessFragment());
        setMyFragment();

        IntentFilter intentFilter = new IntentFilter("com.example.broadcasttest.MY_BROADCAST");
        registerReceiver(myReceiver,intentFilter);


        viewPager.setAdapter(new SectionsPagerAdapter(getSupportFragmentManager(), fragments));
        viewPager.addOnPageChangeListener(this);
        viewPager.setCurrentItem(0);
    }

    private void setMyFragment() {
        fragments.add(new PersonalUnloginFragment());

    }
    //用于接收登录成功后获取的消息来改变相应fragment
    public class MyReceiver extends BroadcastReceiver{

        public MyReceiver() {

        }

        @Override
        public void onReceive(Context context, Intent intent) {
            String mobile = intent.getStringExtra("key");
            Log.e("tag","mobile==========="+mobile);
            if (mobile.isEmpty()){
                setMyFragment();
            }else{
                fragments.add(new PersonalFragment());
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiver);
    }

    /**
     * 设置默认的fragment
     */

    @Override
    public void onTabSelected(int position) {

        viewPager.setCurrentItem(position);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        bottomNavigationBar.selectTab(position);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}
