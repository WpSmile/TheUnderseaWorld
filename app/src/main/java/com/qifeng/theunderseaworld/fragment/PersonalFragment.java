package com.qifeng.theunderseaworld.fragment;


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
import com.qifeng.theunderseaworld.adapter.PersinalCustomerTuijianAdapter;
import com.qifeng.theunderseaworld.bean.PersonalCustomerTuijianBean;
import com.qifeng.theunderseaworld.utils.MFGT;
import com.qifeng.theunderseaworld.view.ImageViewPlus;
import com.qifeng.theunderseaworld.view.SpaceItemDecoretion;

import java.util.ArrayList;

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

    ArrayList<PersonalCustomerTuijianBean> list;
    PersinalCustomerTuijianAdapter mAdapter;
    LinearLayoutManager manager;
    int pageId;

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
        list = new ArrayList<>();
        initView();
        return view;
    }

    private void initView() {
        PersonalCustomerTuijianBean bean = new PersonalCustomerTuijianBean();
        bean.setImage(R.drawable.today_activity_default);
        bean.setTitle("神奇的海底隧道");
        bean.setSign("多姿多彩的海洋生物，将神秘莫测、变化万千、绚丽多彩的海洋世界展示在广大市民眼前....");
        bean.setPrice("￥35");
        bean.setPercent("97%");

        for (int i = 0; i < 2; i++) {
            list.add(bean);
        }

        mAdapter = new PersinalCustomerTuijianAdapter(mContext, list);
        manager = new LinearLayoutManager(mContext);
        itemCustomerRecyclerView.setLayoutManager(manager);
        itemCustomerRecyclerView.setAdapter(mAdapter);

        //设置是否自动修复
        itemCustomerRecyclerView.setHasFixedSize(true);
        itemCustomerRecyclerView.addItemDecoration(new SpaceItemDecoretion(8));
    }

    @OnClick({R.id.item_customer_personal_info_rl, R.id.item_customer_order_manager_rl, R.id.item_customer_pay_system_rl,
            R.id.item_customer_yu_e_manage_rl, R.id.item_customer_pingjia_system_rl,
            R.id.personal_customer_my_order, R.id.personal_customer_daifukuan, R.id.personal_customer_daishouhuo, R.id.personal_customer_daipingjia})
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
            case R.id.personal_customer_my_order:
                MFGT.gotoOrderManagementActivity(mContext);
                break;
            case R.id.personal_customer_daifukuan:
                MFGT.gotoOrderManagementActivity(mContext);
                break;
            case R.id.personal_customer_daishouhuo:
                MFGT.gotoOrderManagementActivity(mContext);
                break;
            case R.id.personal_customer_daipingjia:
                MFGT.gotoOrderManagementActivity(mContext);
                break;
        }
    }
}
