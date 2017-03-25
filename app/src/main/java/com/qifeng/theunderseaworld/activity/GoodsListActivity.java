package com.qifeng.theunderseaworld.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.HeadGridView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshHeadGridView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.adapter.MallAdapter;
import com.qifeng.theunderseaworld.seabed_service.SeabedService;
import com.qifeng.theunderseaworld.seabed_state.BaseActivity;
import com.qifeng.theunderseaworld.seabed_state.SeabedState;
import com.qifeng.theunderseaworld.seabed_state.StatusBarCompat;
import com.qifeng.theunderseaworld.utils.MFGT;

import net.cpacm.library.SimpleSliderLayout;
import net.cpacm.library.indicator.ViewpagerIndicator.CirclePageIndicator;
import net.cpacm.library.slider.BaseSliderView;
import net.cpacm.library.slider.ImageSliderView;
import net.cpacm.library.slider.OnSliderClickListener;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 主界面
 * Created by XinAiXiaoWen on 2017/3/16.
 */

public class GoodsListActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener, PullToRefreshBase.OnRefreshListener2<HeadGridView> {

    //输出日志显示所用
    private String TAG = MainActivity.class.getSimpleName();

    //逻缉层
    private SeabedState seabedState = SeabedState.getSeabedState();

    //图片加载类
    private ImageLoader imageLoader = ImageLoader.getInstance();

    //上下文
    private Context mainContext = null;
    GoodsListActivity mContext;

    //下拉上拉加头部的gridview
    private PullToRefreshHeadGridView mgvSeabedShopplist = null;

    //适配器
    private MallAdapter mallAdapter = null;

    //头部局的viewpage轮播器
    private SimpleSliderLayout vpSeabedMallCarousel = null;

    //指示器
    private CirclePageIndicator ciSeabedMallIndicator = null;

    //网络图片加载
    private String[] urls = {
            "http://ofrf20oms.bkt.clouddn.com/Clannad.jpg",
            "http://ofrf20oms.bkt.clouddn.com/THE%20IDOLM@STER.jpg",
            "http://ofrf20oms.bkt.clouddn.com/miku.jpg",
            "http://ofrf20oms.bkt.clouddn.com/wusaki.jpg",
            "http://ofrf20oms.bkt.clouddn.com/%CE%BC%27s.jpg",
            "http://ofrf20oms.bkt.clouddn.com/project.jpg"
    };

    //头组件
    private View header = null;

    private Handler mHandler = new Handler();

    //Service
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.e(TAG, "---创建---");

        //去掉标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //API19以下用于沉侵式菜单栏
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        //加载布局
        setContentView(R.layout.activity_goodslist);
        ButterKnife.bind(this);

        //API>=20以上用于沉侵式菜单栏
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            //沉侵
            StatusBarCompat.compat(this, getResources().getColor(R.color.seabed_item_mall_line));
        }

        mContext = this;

        //初始化前
        initMainAgo();

        //初始化控件
        initMainView();

        //注册监听器
        initMainListener();

        //适配器
        initMainAdapter();

        //初始化
        initMainBack();
    }

    /**
     * 初始化前
     */
    private void initMainAgo() {
        //上下文
        mainContext = this;
        //添加布局
        header = LayoutInflater.from(mainContext).inflate(R.layout.mall_header, null);
        //开启后台
        Intent serviceIntent = new Intent(this, SeabedService.class);
        bindService(serviceIntent, serviceConnection, Context.BIND_AUTO_CREATE);
        //初始化ImageLoader，否则会报错
        imageLoader.init(ImageLoaderConfiguration.createDefault(mainContext));
    }

    /**
     * 初始化控件
     */
    private void initMainView() {
        //gridiew
        mgvSeabedShopplist = (PullToRefreshHeadGridView) this.findViewById(R.id.mgv_seabed_shopplist);
        //轮播器
        vpSeabedMallCarousel = (SimpleSliderLayout) header.findViewById(R.id.vp_seabed_mall_carousel);
        //指示器
        ciSeabedMallIndicator = (CirclePageIndicator) header.findViewById(R.id.ci_seabed_mall_indicator);
    }

    /**
     * 注册监听
     */
    private void initMainListener() {
        //gridview
        mgvSeabedShopplist.setOnItemClickListener(this);
        //下拉事件监听器
        mgvSeabedShopplist.setOnRefreshListener(this);
    }

    /**
     * 适配器
     */
    private void initMainAdapter() {
        //获得头部局
        HeadGridView headGridView = mgvSeabedShopplist.getRefreshableView();
        //添加头布局
        headGridView.addHeaderView(header);
        //实例化适配器
        mallAdapter = new MallAdapter(mainContext);
        //绑定适配器
        mgvSeabedShopplist.setAdapter(mallAdapter);

    }

    /**
     * 初始化后
     */
    private void initMainBack() {
        //添加图片
        for (int i = 0; i < urls.length; i++) {
            ImageSliderView sliderView = new ImageSliderView(mainContext);
            imageLoader.displayImage(urls[i], sliderView.getImageView());
            sliderView.setOnSliderClickListener(new OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView slider) {

                }
            });
            vpSeabedMallCarousel.addSlider(sliderView);
        }
        //无限循环
        vpSeabedMallCarousel.setCycling(true);
        //自动循环
        vpSeabedMallCarousel.setAutoCycling(true);
        //每隔3秒进行翻页
        vpSeabedMallCarousel.setSliderDuration(3000);
        //翻页的速度为1秒
        vpSeabedMallCarousel.setSliderTransformDuration(1000);
        //为slider设置特定的动画
        vpSeabedMallCarousel.setAnimationListener(null);
        //为viewpager设置指示器
        vpSeabedMallCarousel.setViewPagerIndicator(ciSeabedMallIndicator);
    }

    /**
     * 跳转
     *
     * @param activity
     * @param position
     */
    private void initMainIntent(Class<?> activity, int position) {
        Intent intent = new Intent(mainContext, activity);
        startActivity(intent);
    }

    /**
     * 响应事件
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        initMainIntent(DetailsActivity.class, position);
    }

    /**
     * 下拉刷新
     *
     * @param refreshView
     */
    @Override
    public void onPullDownToRefresh(PullToRefreshBase<HeadGridView> refreshView) {
        Toast.makeText(getApplicationContext(), "下拉", Toast.LENGTH_SHORT).show();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mgvSeabedShopplist.onRefreshComplete();
            }
        }, 3000);
    }

    /**
     * 下拉加载
     *
     * @param refreshView
     */
    @Override
    public void onPullUpToRefresh(PullToRefreshBase<HeadGridView> refreshView) {
        Toast.makeText(getApplicationContext(), "上拉", Toast.LENGTH_SHORT).show();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mgvSeabedShopplist.onRefreshComplete();
            }
        }, 3000);
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
        vpSeabedMallCarousel.setAutoCycling(false);//自动循环
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
        vpSeabedMallCarousel.setAutoCycling(true);//自动循环
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "---销毁---");
        unbindService(serviceConnection);
    }

    @OnClick({R.id.imageView, R.id.goods_list_image_shop_car})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageView://
                MFGT.finish(this);
                break;
            case R.id.goods_list_image_shop_car:
                Intent intent = new Intent();
                intent.setClass(this,CartActivity.class);
                startActivity(intent);
                break;
        }
    }
}
