package com.qifeng.theunderseaworld.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.activity.MainActivity;
import com.qifeng.theunderseaworld.utils.MFGT;
import com.qifeng.theunderseaworld.view.ImageViewPlus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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

    public PersonalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.item_customer, container, false);
        ButterKnife.bind(this, view);
        mContext = (MainActivity) getActivity();
        return view;
    }

    @OnClick({R.id.item_customer_personal_info_rl, R.id.item_customer_order_manager_rl, R.id.item_customer_pay_system_rl, R.id.item_customer_yu_e_manage_rl, R.id.item_customer_pingjia_system_rl})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.item_customer_personal_info_rl://个人信息
                //MFGT.gotoPersonalInfoActivity(mContext);
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
        }
    }
}
