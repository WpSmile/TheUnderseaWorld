package com.qifeng.theunderseaworld.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.fragment.OrderFinishedFragment;
import com.qifeng.theunderseaworld.fragment.OrderFinishingFragment;
import com.qifeng.theunderseaworld.fragment.OrderTuikuanFragment;
import com.qifeng.theunderseaworld.utils.MFGT;
import com.qifeng.theunderseaworld.utils.StatusBarCompat;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
/*
*
* 用户的订单管理
* */
public class OrderManagementActivity extends AppCompatActivity {
    private final static String TAG = OrderManagementActivity.class.getCanonicalName();
    OrderManagementActivity mContext;

    @BindView(R.id.order_manager_btn_daying)
    Button orderManagerBtnDaying;
    @BindView(R.id.order_manager_recyclerView)
    RecyclerView orderManagerRecyclerView;
    @BindView(R.id.order_manager_fragment)
    FrameLayout orderManagerFragment;


    ArrayList<Fragment> fragmentList = new ArrayList<>();
    OrderFinishedFragment orderFinishedFragment;
    OrderFinishingFragment orderFinishingFragment;
    OrderTuikuanFragment orderTuikuanFragment;

    int currentFragmentIndex = 0;
    int clickButtonIndex;
    Button[] btnArray = new Button[3];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //API19以下用于沉侵式菜单栏
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_order_management);

        //API20以上
        if (Build.VERSION.SDK_INT>Build.VERSION_CODES.KITKAT){
            //沉侵
            StatusBarCompat.compat(this,getResources().getColor(R.color.bottom_blue));
        }
        ButterKnife.bind(this);
        mContext = this;

        initView();
        initData();
        setListener();
    }

    private void setListener() {

    }

    private void initData() {

    }

    private void initView() {
        orderManagerBtnDaying.setText("删除");
        setFragment();
    }

    private void setFragment() {
        //fragments = new Fragment[]{};
        orderFinishedFragment = new OrderFinishedFragment();
        orderFinishingFragment = new OrderFinishingFragment();
        orderTuikuanFragment = new OrderTuikuanFragment();

        fragmentList.add(orderFinishedFragment);
        fragmentList.add(orderFinishingFragment);
        fragmentList.add(orderTuikuanFragment);

        btnArray[0] = (Button) findViewById(R.id.order_manager_btn_finished);
        btnArray[1] = (Button) findViewById(R.id.order_manager_btn_finishing);
        btnArray[2] = (Button) findViewById(R.id.order_manager_btn_tuikuan);

        //默认的显示的fragment
        Fragment showFragment = fragmentList.get(currentFragmentIndex);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.order_manager_fragment, showFragment)
                .show(showFragment).commit();

        //设置默认的按钮的颜色
        btnArray[currentFragmentIndex].setTextColor(getResources().getColor(R.color.bottom_blue));
    }



    private void initOrderBusinessView() {

    }

    private void initOrderCustomerView() {
        orderManagerBtnDaying.setText("删除");
    }

    @OnClick({R.id.order_manager_img_back, R.id.order_manager_btn_daying, R.id.order_manager_btn_finished, R.id.order_manager_btn_finishing, R.id.order_manager_btn_tuikuan})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.order_manager_img_back:
                MFGT.finish(this);
                break;
            case R.id.order_manager_btn_daying:
                break;
            case R.id.order_manager_btn_finished:
                clickButtonIndex = 0;
                break;
            case R.id.order_manager_btn_finishing:
                clickButtonIndex = 1;
                break;
            case R.id.order_manager_btn_tuikuan:
                clickButtonIndex = 2;
                break;
        }

        if (currentFragmentIndex != clickButtonIndex) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            //隐藏当前的fragment
            transaction.hide(fragmentList.get(currentFragmentIndex));
            // 显示 点击的button对应的gragment
            Fragment showFragment = fragmentList.get(clickButtonIndex);
            // 没有添加过，
            if (!showFragment.isAdded()) {
                transaction.add(R.id.order_manager_fragment, showFragment);
            }
            transaction.show(showFragment);
            transaction.commit();
            //设置按钮的状态
            setButtonStatus();
            currentFragmentIndex = clickButtonIndex;
        }
    }

    private void setButtonStatus() {
        btnArray[currentFragmentIndex].setSelected(false);
        btnArray[currentFragmentIndex].setTextColor(getResources().getColor(R.color.gray));
        btnArray[currentFragmentIndex].setBackground(getResources().getDrawable(R.drawable.button_white_with_solid));

        btnArray[clickButtonIndex].setSelected(true);
        btnArray[clickButtonIndex].setTextColor(getResources().getColor(R.color.bottom_blue));
        btnArray[clickButtonIndex].setBackground(getResources().getDrawable(R.drawable.item_cart_layout_noradius));
    }
}
