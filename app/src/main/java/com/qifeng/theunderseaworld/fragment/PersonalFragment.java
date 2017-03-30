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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qifeng.theunderseaworld.I;
import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.activity.MainActivity;
import com.qifeng.theunderseaworld.activity.PersonalActivity;
import com.qifeng.theunderseaworld.adapter.PersinalCustomerTuijianAdapter;
import com.qifeng.theunderseaworld.bean.CartTuijianBean;
import com.qifeng.theunderseaworld.bean.PersonalCustomerTuijianBean;
import com.qifeng.theunderseaworld.utils.HttpRequestWrap;
import com.qifeng.theunderseaworld.utils.MFGT;
import com.qifeng.theunderseaworld.utils.OnResponseHandler;
import com.qifeng.theunderseaworld.utils.RequestHandler;
import com.qifeng.theunderseaworld.utils.RequestStatus;
import com.qifeng.theunderseaworld.view.ImageViewPlus;
import com.qifeng.theunderseaworld.view.SpaceItemDecoretion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    ArrayList<CartTuijianBean> list;
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
        initData();
        return view;
    }

    private void initData() {
        downloadCainixihuan();

    }

    private void downloadCainixihuan() {
        HttpRequestWrap httpRequestWrap;
        httpRequestWrap = new HttpRequestWrap(getContext());
        httpRequestWrap.setMethod(HttpRequestWrap.POST);
        httpRequestWrap.setCallBack(new RequestHandler(getContext(), new OnResponseHandler() {
            @Override
            public void onResponse(String s, RequestStatus status) {
                if (status == RequestStatus.SUCCESS) {
                    if (!s.isEmpty()) {
                        JSONObject jsonObject = JSONObject.parseObject(s);
                        JSONObject j = jsonObject.getJSONObject("result");
                        JSONArray array = j.getJSONArray("retData");
                        for (int i = 0; i < array.size(); i++) {
                            CartTuijianBean bean = new CartTuijianBean();
                            JSONObject x = array.getJSONObject(i);
                            bean.setGoodsId(x.getString("goods_id"));
                            bean.setGoodsTitle(x.getString("goods_title"));
                            bean.setGoodsPrice(x.getString("goods_price"));
                            list.add(bean);
                        }
                        mAdapter.initData(list);
                    }
                }
            }
        }));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("num", 3 + "");
        httpRequestWrap.send(I.SERVER_URL + "HootGoods" + I.INDEX, map);
    }

    private void initView() {
        list = new ArrayList<>();

        manager = new LinearLayoutManager(mContext);
        mAdapter = new PersinalCustomerTuijianAdapter(mContext, list);

        itemCustomerRecyclerView.setAdapter(mAdapter);
        itemCustomerRecyclerView.setLayoutManager(manager);
        itemCustomerRecyclerView.setHasFixedSize(true);
        itemCustomerRecyclerView.addItemDecoration(new SpaceItemDecoretion(8));

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
