package com.qifeng.theunderseaworld.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.activity.MainActivity;
import com.qifeng.theunderseaworld.activity.PersonalActivity;
import com.qifeng.theunderseaworld.adapter.PersinalCustomerTuijianAdapter;
import com.qifeng.theunderseaworld.bean.PersonalCustomerTuijianBean;
import com.qifeng.theunderseaworld.utils.MFGT;
import com.qifeng.theunderseaworld.view.ImageViewPlus;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalFragment extends Fragment {
    MainActivity mContext;
    @BindView(R.id.item_customer_ivp_avatar)
    ImageViewPlus itemCustomerIvpAvatar;
    @BindView(R.id.item_customer_iv_sex)
    ImageView itemCustomerIvSex;
    @BindView(R.id.item_customer_recyclerView)
    RecyclerView itemCustomerRecyclerView;
    Unbinder unbinder;

    PersinalCustomerTuijianAdapter mAdapter;
    ArrayList<PersonalCustomerTuijianBean> list;
    LinearLayoutManager manager;


    public PersonalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.item_customer, container, false);
        unbinder = ButterKnife.bind(this, view);
        mContext = (MainActivity) getActivity();

        initView();
        return view;
    }

    private void initView() {
        list = new ArrayList<>();

        PersonalCustomerTuijianBean bean = new PersonalCustomerTuijianBean();
        bean.setImage(R.drawable.today_activity_default);
        bean.setTitle("神奇的海底隧道");
        bean.setSign("多姿多彩的海洋生物，将神秘莫测、变化万千、绚丽多彩的海洋世界展示在广大市民眼前....");
        bean.setPrice("￥35");
        bean.setPercent("好评率97%");
        for (int i = 0; i < 2; i++) {
            list.add(bean);
        }

        manager = new LinearLayoutManager(mContext);
        mAdapter = new PersinalCustomerTuijianAdapter(mContext, list);

        itemCustomerRecyclerView.setAdapter(mAdapter);
        itemCustomerRecyclerView.setLayoutManager(manager);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.item_customer_personal_info_rl, R.id.item_customer_order_manager_rl, R.id.item_customer_pay_system_rl,
            R.id.item_customer_yu_e_manage_rl, R.id.item_customer_pingjia_system_rl, R.id.tv_personal_customer_more,
            R.id.personal_customer_my_order, R.id.personal_customer_daifukuan, R.id.personal_customer_daishouhuo, R.id.personal_customer_daipingjia})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.item_customer_personal_info_rl://个人信息
                Intent intent = new Intent();
                intent.setClass(mContext, PersonalActivity.class);
                startActivity(intent);
                break;
            case R.id.item_customer_order_manager_rl://订单管理
                MFGT.gotoOrderManagementActivity(mContext);
                break;
            case R.id.item_customer_pay_system_rl://支付系统
                MFGT.gotoPaySystemActivity(mContext);
                break;
            case R.id.item_customer_yu_e_manage_rl://余额管理
                MFGT.gotoYuEActivity(mContext);
                break;
            case R.id.item_customer_pingjia_system_rl://评价系统
                MFGT.gotoPingjiaSystemActivity(mContext);
                break;
            case R.id.tv_personal_customer_more://猜你喜欢的更多(跳转至商品列表)
                MFGT.gotoGoodsListActivity(mContext);
                break;
            case R.id.personal_customer_my_order://我的订单
                MFGT.gotoOrderManagementActivity(mContext);
                break;
            case R.id.personal_customer_daifukuan://待付款
                MFGT.gotoOrderManagementActivity(mContext);
                break;
            case R.id.personal_customer_daishouhuo://待收货
                MFGT.gotoOrderManagementActivity(mContext);
                break;
            case R.id.personal_customer_daipingjia://待评价
                MFGT.gotoOrderManagementActivity(mContext);
                break;
            case R.id.item_customer_pesonal_rl_avatar://点击头像跳转至个人中心
                MFGT.gotoPersonalActivity(mContext);
                break;
        }
    }


}
