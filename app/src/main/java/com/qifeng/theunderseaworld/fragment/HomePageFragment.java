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
import com.qifeng.theunderseaworld.adapter.HomeKePuAnimalAdapter;
import com.qifeng.theunderseaworld.bean.HomeKePuAnimalBean;
import com.qifeng.theunderseaworld.utils.MFGT;
import com.qifeng.theunderseaworld.view.FlowIndicator;
import com.qifeng.theunderseaworld.view.SlideAutoLoopView;

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
    @BindView(R.id.home_slideAuto)
    SlideAutoLoopView homeSlideAuto;
    @BindView(R.id.home_flowIndicator)
    FlowIndicator homeFlowIndicator;


    public HomePageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //mContext = (MainActivity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        ButterKnife.bind(this, view);
        mContext = (MainActivity) getActivity();
        initView();
        initData();
        return view;
    }

    private void initData() {
        String[] image = new String[4];
        homeSlideAuto.startPlayLoop(homeFlowIndicator,image,4);
    }

    private void initView() {
        mKepulist = new ArrayList<>();
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
        //homeRvKepu.setLayoutManager(gridLayoutManager);
        //homeRvKepu.setAdapter(mAdapter);
        homeRvKepu.setHasFixedSize(true);
        homeRvKepu.addItemDecoration(new SpaceItemDecoretion(12));

    }


    @OnClick({R.id.home_introduce_iamge, R.id.home_map_iamge, R.id.home_activity_iamge, R.id.home_text_more1, R.id.home_text_more2})
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
        }
    }
}
