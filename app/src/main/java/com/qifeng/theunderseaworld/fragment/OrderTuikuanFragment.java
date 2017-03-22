package com.qifeng.theunderseaworld.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.adapter.OrderTuikuanCustomerAdapter;
import com.qifeng.theunderseaworld.bean.OrderFinishedChildBean;
import com.qifeng.theunderseaworld.bean.OrderFinishedGroupBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderTuikuanFragment extends Fragment {

    int pageId = 1;
    Context mContext;

    ArrayList<OrderFinishedGroupBean> groupList;
    ArrayList<OrderFinishedChildBean> childList;
    int parent_id;
    OrderTuikuanCustomerAdapter mAdapter;
    @BindView(R.id.order_customer_tuikuan_expanlist)
    ExpandableListView orderCustomerTuikuanExpanlist;


    public OrderTuikuanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_order_tuikuan, container, false);
        ButterKnife.bind(this, view);

        mContext = getActivity();
        groupList = new ArrayList<>();
        childList = new ArrayList<>();

        initView();
        initData();
        setListener();
        return view;
    }


    private void setListener() {
        orderCustomerTuikuanExpanlist.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return true;
            }
        });
    }

    private void initData() {

    }

    private void initView() {
        OrderFinishedGroupBean groupBean = new OrderFinishedGroupBean();
        groupBean.setGroup_order_num("订单号：10000000000");
        groupList.add(groupBean);


        OrderFinishedChildBean childBean = new OrderFinishedChildBean();
        childBean.setImage(R.drawable.today_activity_default);
        childBean.setTitle("海底世界儿童票");
        childBean.setSign("海底世界官方旗舰店");
        childBean.setPrice("￥35");
        childBean.setChild_order_num("物流单号：10000000000");

        for (int i = 0; i < 2; i++) {
            childList.add(childBean);
        }


        mAdapter = new OrderTuikuanCustomerAdapter(mContext, groupList, childList);
        orderCustomerTuikuanExpanlist.setAdapter(mAdapter);

        for (int i = 0; i < groupList.size(); i++) {
            orderCustomerTuikuanExpanlist.expandGroup(i);
        }
    }


}
