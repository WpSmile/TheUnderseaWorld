package com.qifeng.theunderseaworld.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.adapter.DetailsAdapter;
import com.qifeng.theunderseaworld.seabed_state.BaseActivity;
import com.qifeng.theunderseaworld.seabed_state.StatusBarCompat;
import com.qifeng.theunderseaworld.view.ListViewForScrollView;

/**
 * 商品详情页面
 * Created by XinAiXiaoWen on 2017/3/20.
 */

public class DetailsActivity extends BaseActivity implements AdapterView.OnItemClickListener,View.OnClickListener{

    //输出日志所用
    private String TAG = DetailsActivity.class.getSimpleName();

    //上下文
    private Context detailsContext = null;

    //返回
    private ImageView ivSeabedDetailsReturn = null;

    //滑动布局
    private ScrollView svSeabedDetailsLayout = null;

    //图片显示
    private ImageView ivSeabedDetailSign = null;

    //票类
    private TextView tvSeabedDetailsTicket = null;

    //票的来源
    private TextView tvSeabedDetailsFrom = null;

    //钱
    private TextView tvSeabedDetailsMoney = null;

    //减
    private ImageView ivSeabedDetailsMinus = null;

    //数量
    private TextView tvSeabedDetailsNumber = null;

    //加
    private ImageView ivSeabedDetailsAdd = null;

    //分享
    private ImageView ivSeabedDetailsShare = null;

    //标志1
    private TextView tvSeabedDetailsSignone = null;

    //标志4
    private TextView tvSeabedDetailsSigntwo = null;

    //标志3
    private TextView tvSeabedDetailsSignthree = null;

    //留言集合
    private ListViewForScrollView lvSeabedDetailsWord = null;

    //留言集合适配器
    private DetailsAdapter detailsAdapter = null;

    //购物车
    private TextView tvSeabedDetailsCart = null;

    private int moneySum = 35;

    private int moneyNumber = 1;

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
        setContentView(R.layout.activity_details);

        //API>=20以上用于沉侵式菜单栏
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            //沉侵
            StatusBarCompat.compat(this, getResources().getColor(R.color.seabed_item_mall_line));
        }

        //初始化前操作
        initDetailsAgo();

        //初始化控件
        initDetailsView();

        //注册监听器
        initDetailsListener();

        //绑定适配器
        initDetailsAdapter();

        //初始化后操作
        initDetailsBack();
    }

    /**
     * 初始化前操作
     */
    private void initDetailsAgo(){
        detailsContext = this;
    }

    /**
     * 初始化控件
     */
    private void initDetailsView(){
        //返回
        ivSeabedDetailsReturn = (ImageView) this.findViewById(R.id.iv_seabed_details_return);
        //图片显示
        ivSeabedDetailSign = (ImageView) this.findViewById(R.id.iv_seabed_details_sign);
        //滑动控件
        svSeabedDetailsLayout = (ScrollView) this.findViewById(R.id.sv_seabed_details_layout);
        //票类
        tvSeabedDetailsTicket = (TextView) this.findViewById(R.id.tv_seabed_details_ticket);
        //票的来源
        tvSeabedDetailsFrom = (TextView) this.findViewById(R.id.tv_seabed_details_from);
        //钱
        tvSeabedDetailsMoney = (TextView) this.findViewById(R.id.tv_seabed_details_money);
        //减
        ivSeabedDetailsMinus = (ImageView) this.findViewById(R.id.iv_seabed_details_minus);
        //数量
        tvSeabedDetailsNumber = (TextView) this.findViewById(R.id.tv_seabed_details_number);
        //加
        ivSeabedDetailsAdd = (ImageView) this.findViewById(R.id.iv_seabed_details_add);
        //分享
        ivSeabedDetailsShare = (ImageView) this.findViewById(R.id.iv_seabed_details_share);
        //标志1
        tvSeabedDetailsSignone = (TextView) this.findViewById(R.id.tv_seabed_details_signone);
        //标志2
        tvSeabedDetailsSigntwo = (TextView) this.findViewById(R.id.tv_seabed_details_signtwo);
        //标志3
        tvSeabedDetailsSignthree = (TextView) this.findViewById(R.id.tv_seabed_details_signthree);
        //留言集合控件
        lvSeabedDetailsWord = (ListViewForScrollView) this.findViewById(R.id.lv_seabed_details_word);
        //购物车
        tvSeabedDetailsCart = (TextView) this.findViewById(R.id.tv_seabed_details_cart);
    }

    /**
     * 注册监听器
     */
    private void initDetailsListener(){
        //返回注册监听
        ivSeabedDetailsReturn.setOnClickListener(this);
        //减注册监听
        ivSeabedDetailsMinus.setOnClickListener(this);
        //加注册监听
        ivSeabedDetailsAdd.setOnClickListener(this);
        //分享注册监听
        ivSeabedDetailsShare.setOnClickListener(this);
        //留言集合注册监听
        lvSeabedDetailsWord.setOnItemClickListener(this);
        //购物车监听
        tvSeabedDetailsCart.setOnClickListener(this);
    }

    /**
     * 绑定适配器
     */
    private void initDetailsAdapter(){
        detailsAdapter = new DetailsAdapter(detailsContext);
        lvSeabedDetailsWord.setAdapter(detailsAdapter);
    }

    /**
     * 初始化后操作
     */
    private void initDetailsBack(){
        svSeabedDetailsLayout.smoothScrollTo(0,0);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //返回
            case R.id.iv_seabed_details_return:
                finish();
                break;
            //减
            case R.id.iv_seabed_details_minus:
                moneyNumber --;
                if(moneyNumber == 0){
                    moneyNumber = 1;
                }
                tvSeabedDetailsNumber.setText(moneyNumber+"");
                moneySum*=moneyNumber;
                tvSeabedDetailsMoney.setText("￥"+moneySum);
                break;
            //加
            case R.id.iv_seabed_details_add:
                moneyNumber++;
                tvSeabedDetailsNumber.setText(moneyNumber+"");
                moneySum*=moneyNumber;
                tvSeabedDetailsMoney.setText("￥"+moneySum);
                break;
            //分享
            case R.id.iv_seabed_details_share:
                break;
            //购物车
            case R.id.tv_seabed_details_cart:
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

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
