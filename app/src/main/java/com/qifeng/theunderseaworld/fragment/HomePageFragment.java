package com.qifeng.theunderseaworld.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.qifeng.theunderseaworld.I;
import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.activity.MainActivity;
import com.qifeng.theunderseaworld.bean.Result;
import com.qifeng.theunderseaworld.utils.HttpRequestWrap;
import com.qifeng.theunderseaworld.utils.L;
import com.qifeng.theunderseaworld.utils.OkHttpUtils;
import com.qifeng.theunderseaworld.utils.OkUtils;
import com.qifeng.theunderseaworld.utils.OnResponseHandler;
import com.qifeng.theunderseaworld.utils.RequestHandler;
import com.qifeng.theunderseaworld.utils.RequestStatus;
import com.qifeng.theunderseaworld.utils.ResultUtils;
import com.qifeng.theunderseaworld.view.SpaceItemDecoretion;
import com.qifeng.theunderseaworld.adapter.HomeKePuAnimalAdapter;
import com.qifeng.theunderseaworld.adapter.HomeTuijianAdapter;
import com.qifeng.theunderseaworld.bean.CartTuijianBean;
import com.qifeng.theunderseaworld.bean.HomeKePuAnimalBean;
import com.qifeng.theunderseaworld.utils.MFGT;
import com.qifeng.theunderseaworld.view.FlowIndicator;
import com.qifeng.theunderseaworld.view.SlideAutoLoopView;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 首页
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
    @BindView(R.id.home_slideAuto)
    SlideAutoLoopView homeSlideAuto;
    @BindView(R.id.home_flowIndicator)
    FlowIndicator homeFlowIndicator;


    private String sessionID;

    private HttpRequestWrap httpRequestWrap = null;

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
        String[] imageurl = {"miku.jpg", "wusaki.jpg", "%CE%BC%27s.jpg", "project.jpg"};

        homeSlideAuto.startPlayLoop(homeFlowIndicator, imageurl, imageurl.length);
        //homeSlideAuto.startPlayLoop(myView, getAlbumImgUrl(details), getAlbumImgCount(details));

        downloadKePuAnimal();
        downloadHomeTuijian();
    }

    private void downloadHomeTuijian() {
        httpRequestWrap = new HttpRequestWrap(getContext());
        httpRequestWrap.setMethod(HttpRequestWrap.POST);
        httpRequestWrap.setCallBack(new RequestHandler(getContext(), new OnResponseHandler() {
            @Override
            public void onResponse(String s, RequestStatus status) {
                if (status == RequestStatus.SUCCESS) {
                    if (!s.isEmpty()) {
                        JSONObject jsonObject = JSONObject.parseObject(s);
                        Log.e("tag", "jsonObject=================" + jsonObject.toString());
                        String result = jsonObject.getString("result");
                        Log.e("tag", "result=============" + result);

                        JSONObject jsonObject1 = JSONObject.parseObject(result);
                        String retData = jsonObject1.getString("retData");

                        Log.e("tag","retData================="+retData);

                        Gson gson = new Gson();
                        CartTuijianBean[] cartTuijianBeen = gson.fromJson(retData, CartTuijianBean[].class);

                        for (int i = 0; i < cartTuijianBeen.length; i++) {
                            tuijianList.add(cartTuijianBeen[i]);
                        }

                        homeTuijianAdapter.initData(tuijianList);

                    }
                }
            }
        }));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("goods_id", 78 + "");
        httpRequestWrap.send(I.SERVER_URL + "GoodsDetails" + I.INDEX, map);
    }

    private void downloadKePuAnimal() {

        httpRequestWrap = new HttpRequestWrap(getContext());
        httpRequestWrap.setMethod(HttpRequestWrap.POST);
        httpRequestWrap.setCallBack(new RequestHandler(getContext(), new OnResponseHandler() {
            @Override
            public void onResponse(String s, RequestStatus status) {
                if (status == RequestStatus.SUCCESS) {
                    if (!s.isEmpty()) {
                        JSONObject jsonObject = JSONObject.parseObject(s);
                        //Log.e("tag", "jsonObject=================" + jsonObject.toString());
                        String result = jsonObject.getString("result");

                        JSONObject jsonObject1 = JSON.parseObject(result);

                        String retData = jsonObject1.getString("retData");
                        Log.e("tag","retData================="+retData);


                        Gson gson = new Gson();
                        HomeKePuAnimalBean[] homeKePuAnimalBeen = gson.fromJson(retData, HomeKePuAnimalBean[].class);

                        Log.e("tag","homeKePuAnimalBeen=============="+homeKePuAnimalBeen.toString());

                        for (int i = 0; i < homeKePuAnimalBeen.length; i++) {
                            mKepulist.add(homeKePuAnimalBeen[i]);
                            Log.e("tag","homeKePuAnimalBeen[i]============"+homeKePuAnimalBeen[i].toString());
                        }
                        Log.e("tag","mKePulist============"+mKepulist.size());
                        mAdapter.initData(mKepulist);
                    }
                }
            }
        }));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("num", 4 + "");
        httpRequestWrap.send(I.SERVER_URL + "ScienceList" + I.INDEX, map);

    }

    private void initView() {
        //设置首页科普默认数据
        setHomeDefaultKepu();


        //设置首页热门推荐的默认数据
        setHomeDefaultCommondView();


    }

    private void setHomeDefaultKepu() {


        gridLayoutManager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
        mAdapter = new HomeKePuAnimalAdapter(mContext, mKepulist);
        homeRvKepu.setLayoutManager(gridLayoutManager);
        homeRvKepu.setAdapter(mAdapter);
        homeRvKepu.setHasFixedSize(true);
        homeRvKepu.addItemDecoration(new SpaceItemDecoretion(12));

    }

    private void setHomeDefaultCommondView() {

        gridLayoutManager1 = new GridLayoutManager(mContext, 3, LinearLayoutManager.VERTICAL, false);
        homeTuijianAdapter = new HomeTuijianAdapter(mContext, tuijianList);
        homeRvRecommend.setAdapter(homeTuijianAdapter);
        homeRvRecommend.setLayoutManager(gridLayoutManager1);
        //设置是否自动修复
        homeRvRecommend.setHasFixedSize(true);
        homeRvRecommend.addItemDecoration(new SpaceItemDecoretion(8));

    }


    @OnClick({R.id.home_introduce_iamge, R.id.home_map_iamge, R.id.home_activity_iamge, R.id.home_text_more1, R.id.home_text_more2, R.id.home_iamge_category})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_introduce_iamge://南宁海底世界简介
                MFGT.gotoIntroduceActivity(mContext);
                break;
            case R.id.home_map_iamge://管内导览图
                MFGT.gotoMapActivity(mContext);
                break;
            case R.id.home_activity_iamge://今日活动
                MFGT.gotoTodayActivity(mContext);
                break;
            case R.id.home_text_more1://海洋动物科普
                MFGT.gotoAnimalKePuActivity(mContext);
                break;
            case R.id.home_text_more2://跳转至商品列表
                MFGT.gotoGoodsListActivity(mContext);
                break;
            case R.id.home_iamge_category://购物车
                MFGT.gotoCartActivity(mContext);
                break;
        }
    }
}
