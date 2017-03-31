package com.qifeng.theunderseaworld.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qifeng.theunderseaworld.I;
import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.activity.MainActivity;
import com.qifeng.theunderseaworld.utils.HttpRequestWrap;
import com.qifeng.theunderseaworld.utils.OnResponseHandler;
import com.qifeng.theunderseaworld.utils.RequestHandler;
import com.qifeng.theunderseaworld.utils.RequestStatus;
import com.qifeng.theunderseaworld.view.SpaceItemDecoretion;
import com.qifeng.theunderseaworld.adapter.HomeKePuAnimalAdapter;
import com.qifeng.theunderseaworld.adapter.HomeTuijianAdapter;
import com.qifeng.theunderseaworld.bean.CartTuijianBean;
import com.qifeng.theunderseaworld.bean.HomeKePuAnimalBean;
import com.qifeng.theunderseaworld.utils.MFGT;
import com.qifeng.theunderseaworld.view.FlowIndicator;
import com.qifeng.theunderseaworld.view.SlideAutoLoopView;


import java.util.ArrayList;
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
    final String DEFAULT_ID = 71 + "";
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


    String[] imageurl;
    ArrayList<String> imageurlList;

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

        imageurlList = new ArrayList<>();

        initView();
        initData();
        return view;
    }

    private void initData() {
        downloadHomeSlideAuto();//下载首页轮播图的方法
        downloadKePuAnimal();//下载首页动物科普item的方法
        downloadHomeTuijian();//下载首页热销推荐item的方法
    }

    private void downloadHomeSlideAuto() {
        httpRequestWrap = new HttpRequestWrap(getContext());
        httpRequestWrap.setMethod(HttpRequestWrap.GET);
        httpRequestWrap.setCallBack(new RequestHandler(getContext(), new OnResponseHandler() {
            @Override
            public void onResponse(String s, RequestStatus status) {
                if (status == RequestStatus.SUCCESS) {
                    if (!s.isEmpty()) {

                        Log.e("tag", "s-----------------------" + s);
                        JSONObject jsonObject = JSONObject.parseObject(s);
                        JSONObject j = jsonObject.getJSONObject("result");
                        JSONArray array = j.getJSONArray("retData");
                        imageurl = new String[array.size()];
                        for (int i = 0; i < array.size(); i++) {
                            JSONObject image = array.getJSONObject(i);
                            String path = image.getString("path");

                            Log.e("tag", "path------------------------" + path);
                            imageurl[i] = path;

                        }
                        Log.e("tag", "imageurl-----------------------" + imageurl.toString());
                        showSlideAutoDetails();//显示图片轮播的方法
                    }
                }
            }
        }));
        Map<String, Object> map = new HashMap<>();
        httpRequestWrap.send(I.SERVER_URL + "Carousel" + I.INDEX, map);
    }

    private void showSlideAutoDetails() {
        homeSlideAuto.startPlayLoop(homeFlowIndicator, imageurl, imageurl.length);
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


                        JSONObject j = jsonObject.getJSONObject("result");

                        JSONArray array = j.getJSONArray("retData");


                        for (int i = 0; i < array.size(); i++) {
                            CartTuijianBean bean1 = new CartTuijianBean();
                            JSONObject x = array.getJSONObject(i);
                            bean1.setGoodsId(x.getString("goods_id"));
                            bean1.setGoodsTitle(x.getString("goods_title"));
                            bean1.setGoodsPrice(x.getString("goods_price"));

                            tuijianList.add(bean1);

                        }

                        homeTuijianAdapter.initData(tuijianList);

                    }
                }
            }
        }));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("num", 3 + "");
        httpRequestWrap.send(I.SERVER_URL + "HootGoods" + I.INDEX, map);
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


                        JSONObject j = jsonObject.getJSONObject("result");

                        JSONArray array = j.getJSONArray("retData");


                        for (int i = 0; i < array.size(); i++) {
                            HomeKePuAnimalBean bean = new HomeKePuAnimalBean();
                            JSONObject x = array.getJSONObject(i);
                            //String mmm = x.getString("goods_title");


                            bean.setScienceEnglishTitle(x.getString("science_english_title"));
                            bean.setScienceId(x.getString("science_id"));
                            bean.setScienceTitle(x.getString("science_title"));

                            mKepulist.add(bean);

                        }
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
                MFGT.gotoAnimalKePuActivity(mContext, DEFAULT_ID);
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
