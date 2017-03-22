package com.qifeng.theunderseaworld.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.activity.MainActivity;
import com.qifeng.theunderseaworld.activity.PaySystemActivity;
import com.qifeng.theunderseaworld.utils.MFGT;
import com.qifeng.theunderseaworld.view.ImageViewPlus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalBusinessFragment extends Fragment {
    //MainActivity mContext;

    @BindView(R.id.personal_ivp_avatar)
    ImageViewPlus personalIvpAvatar;
    @BindView(R.id.personal_iv_sex)
    ImageView personalIvSex;
    Unbinder unbinder;

    public PersonalBusinessFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.item_business, container, false);
        unbinder = ButterKnife.bind(this, view);
        //mContext = (MainActivity) getActivity();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.personal_rl_goods_manager, R.id.personal_rl_vip_manager, R.id.personal_rl_order_manager, R.id.personal_rl_data_manager, R.id.personal_rl_fenquan_manager, R.id.personal_rl_pinjia_manager, R.id.personal_rl_activity_manager, R.id.personal_rl_pay_manager, R.id.personal_rl_tuangou_manager})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.personal_rl_goods_manager://商品管理
                break;
            case R.id.personal_rl_vip_manager://会员管理
                break;
            case R.id.personal_rl_order_manager://订单管理
                //MFGT.gotoOrderManageBusinessActivity(mContext);
                break;
            case R.id.personal_rl_data_manager://数据管理
                break;
            case R.id.personal_rl_fenquan_manager://分权系统
                break;
            case R.id.personal_rl_pinjia_manager://评价系统
                //MFGT.gotoPingjiaSystemBusinessActivity(mContext);
                break;
            case R.id.personal_rl_activity_manager://活动管理
                break;
            case R.id.personal_rl_pay_manager://支付系统
                //PaySystemActivity paySystemActivity = new PaySystemActivity();
                //paySystemActivity.findViewById(R.id.pay_system_btn_mingxi).setVisibility(View.GONE);
                //MFGT.gotoPaySystemActivity(mContext);
                break;
            case R.id.personal_rl_tuangou_manager://团购管理
                //MFGT.gotoTuangouManagerActivity(mContext);
                break;
        }
    }
}
