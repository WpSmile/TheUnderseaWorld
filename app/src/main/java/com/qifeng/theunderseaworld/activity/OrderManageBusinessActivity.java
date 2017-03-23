package com.qifeng.theunderseaworld.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.fragment.OrderFinishedBuninessFragment;
import com.qifeng.theunderseaworld.fragment.OrderFinishedFragment;
import com.qifeng.theunderseaworld.fragment.OrderFinishingBusinessFragment;
import com.qifeng.theunderseaworld.fragment.OrderFinishingFragment;
import com.qifeng.theunderseaworld.fragment.OrderTuikuanBusinessFragment;
import com.qifeng.theunderseaworld.fragment.OrderTuikuanFragment;
import com.qifeng.theunderseaworld.utils.MFGT;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
*
* 商家的订单管理
* */
public class OrderManageBusinessActivity extends AppCompatActivity {
    private final static String TAG = OrderManageBusinessActivity.class.getCanonicalName();
    OrderManageBusinessActivity mContext;

    @BindView(R.id.order_manager_btn_daying)
    Button orderManagerBtnDaying;
    @BindView(R.id.order_manager_recyclerView)
    RecyclerView orderManagerRecyclerView;
    @BindView(R.id.order_manager_fragment)
    FrameLayout orderManagerFragment;


    ArrayList<Fragment> fragmentList = new ArrayList<>();
    OrderFinishedBuninessFragment orderFinishedBuninessFragment;
    OrderFinishingBusinessFragment orderFinishingBusinessFragment;
    OrderTuikuanBusinessFragment orderTuikuanBusinessFragment;

    int currentFragmentIndex = 0;
    int clickButtonIndex;
    Button[] btnArray = new Button[3];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_management);
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
        setFragment();
    }

    private void setFragment() {
        //fragments = new Fragment[]{};
        orderFinishedBuninessFragment = new OrderFinishedBuninessFragment();
        orderFinishingBusinessFragment = new OrderFinishingBusinessFragment();
        orderTuikuanBusinessFragment = new OrderTuikuanBusinessFragment();

        fragmentList.add(orderFinishedBuninessFragment);
        fragmentList.add(orderFinishingBusinessFragment);
        fragmentList.add(orderTuikuanBusinessFragment);

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
        btnArray[clickButtonIndex].setSelected(true);
        btnArray[clickButtonIndex].setTextColor(getResources().getColor(R.color.bottom_blue));
        //btnArray[clickButtonIndex].setBackground(R.drawable.item_cart_layout_noradius);
    }
}
