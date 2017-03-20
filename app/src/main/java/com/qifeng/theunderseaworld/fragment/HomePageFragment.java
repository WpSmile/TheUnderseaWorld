package com.qifeng.theunderseaworld.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.activity.MainActivity;
import com.qifeng.theunderseaworld.activity.SpaceItemDecoretion;
import com.qifeng.theunderseaworld.adapter.CartTuijianAdapter;
import com.qifeng.theunderseaworld.adapter.HomeKePuAnimalAdapter;
import com.qifeng.theunderseaworld.adapter.HomeTuijianAdapter;
import com.qifeng.theunderseaworld.bean.CartTuijianBean;
import com.qifeng.theunderseaworld.bean.HomeKePuAnimalBean;
import com.qifeng.theunderseaworld.utils.MFGT;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends Fragment {
    MainActivity mContext;
    ArrayList<HomeKePuAnimalBean> mKepulist;//动物科普的集合
    @BindView(R.id.home_rv_kepu)
    RecyclerView homeRvKepu;
    GridLayoutManager gridLayoutManager;
    HomeKePuAnimalAdapter mAdapter;

    //热门推荐
    HomeTuijianAdapter homeTuijianAdapter;
    GridLayoutManager gridLayoutManager1;
    ArrayList<CartTuijianBean> tuijianList;
    @BindView(R.id.home_rv_recommend)
    RecyclerView homeRvRecommend;


    public HomePageFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        ButterKnife.bind(this, view);
        mContext = (MainActivity) getActivity();
        mKepulist = new ArrayList<>();
        tuijianList = new ArrayList<>();

        initView();
        initData();
        return view;
    }

    private void initData() {

    }

    private void initView() {
        //设置首页科普默认数据
        setHomeDefaultKepu();


        //设置首页热门推荐的默认数据
        setHomeDefaultCommondView();


    }

    private void setHomeDefaultKepu() {
        //默认数据
        HomeKePuAnimalBean homeKePuAnimalBean = new HomeKePuAnimalBean();
        homeKePuAnimalBean.setImage(R.drawable.nopic);
        homeKePuAnimalBean.setName("鲨鱼");
        //默认数据
        for (int i = 0; i < 4; i++) {
            mKepulist.add(homeKePuAnimalBean);
        }

        gridLayoutManager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
        mAdapter = new HomeKePuAnimalAdapter(mContext, mKepulist);
        homeRvKepu.setLayoutManager(gridLayoutManager);
        homeRvKepu.setAdapter(mAdapter);
        homeRvKepu.setHasFixedSize(true);
        homeRvKepu.addItemDecoration(new SpaceItemDecoretion(12));

    }

    private void setHomeDefaultCommondView() {

        CartTuijianBean cartTuijianBean = new CartTuijianBean();
        cartTuijianBean.setImage(R.drawable.today_activity_default);
        cartTuijianBean.setTitle("南宁海底世界");
        cartTuijianBean.setPrice(35);
        cartTuijianBean.setTicketStyle("老年票");
        for (int i = 0; i < 3; i++) {
            tuijianList.add(cartTuijianBean);
        }

        gridLayoutManager1 = new GridLayoutManager(mContext, 3, LinearLayoutManager.VERTICAL, false);
        homeTuijianAdapter = new HomeTuijianAdapter(mContext, tuijianList);
        homeRvRecommend.setAdapter(homeTuijianAdapter);
        homeRvRecommend.setLayoutManager(gridLayoutManager1);
        //设置是否自动修复
        homeRvRecommend.setHasFixedSize(true);
        homeRvRecommend.addItemDecoration(new SpaceItemDecoretion(12));

    }


    @OnClick({R.id.home_introduce_iamge, R.id.home_map_iamge, R.id.home_activity_iamge, R.id.home_text_more1, R.id.home_text_more2, R.id.home_iamge_category})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_introduce_iamge:
                MFGT.gotoIntroduceActivity(mContext);
                break;
            case R.id.home_map_iamge:
                MFGT.gotoMapActivity(mContext);
                break;
            case R.id.home_activity_iamge:
                MFGT.gotoTodayActivity(mContext);
                break;
            case R.id.home_text_more1:
                MFGT.gotoAnimalKePuActivity(mContext);
                break;
            case R.id.home_text_more2:
                MFGT.gotoHotRecommondActivity(mContext);
                break;
            case R.id.home_iamge_category://购物车
                MFGT.gotoCartActivity(mContext);
                break;
        }
    }
}
