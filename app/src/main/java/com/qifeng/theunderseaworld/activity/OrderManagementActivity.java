package com.qifeng.theunderseaworld.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.fragment.OrderFinishedFragment;
import com.qifeng.theunderseaworld.fragment.OrderFinishingFragment;
import com.qifeng.theunderseaworld.fragment.OrderTuikuanFragment;
import com.qifeng.theunderseaworld.utils.MFGT;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderManagementActivity extends AppCompatActivity {
    private final static String TAG = OrderManagementActivity.class.getCanonicalName();
    OrderManagementActivity mContext;

    @BindView(R.id.order_manager_btn_daying)
    Button orderManagerBtnDaying;
    @BindView(R.id.order_manager_recyclerView)
    RecyclerView orderManagerRecyclerView;
    @BindView(R.id.order_manager_fragment)
    FrameLayout orderManagerFragment;


    private Fragment[] fragments;
    OrderFinishedFragment orderFinishedFragment;
    OrderFinishingFragment orderFinishingFragment;
    OrderTuikuanFragment orderTuikuanFragment;

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
        initOrderCustomerView();//登录用户为顾客时
        initOrderBusinessView();//登录用户为商家时
    }

    private void setFragment() {
        //fragments = new Fragment[]{};
        orderFinishedFragment = new OrderFinishedFragment();
        orderFinishingFragment = new OrderFinishingFragment();
        orderTuikuanFragment = new OrderTuikuanFragment();

        fragments[0] = orderFinishedFragment;
        fragments[1] = orderFinishingFragment;
        fragments[2] = orderTuikuanFragment;

        setDefaultFragment();
    }

    private void setDefaultFragment() {
         getSupportFragmentManager().beginTransaction();
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
                break;
            case R.id.order_manager_btn_finishing:
                break;
            case R.id.order_manager_btn_tuikuan:
                break;
        }
    }
}
