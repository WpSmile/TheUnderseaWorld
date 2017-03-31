package com.qifeng.theunderseaworld.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qifeng.theunderseaworld.I;
import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.adapter.AnimalButtonAdapter;
import com.qifeng.theunderseaworld.bean.AnimalButtonBean;
import com.qifeng.theunderseaworld.bean.AnimalDetailsBean;
import com.qifeng.theunderseaworld.utils.HttpRequestWrap;
import com.qifeng.theunderseaworld.utils.L;
import com.qifeng.theunderseaworld.utils.MFGT;
import com.qifeng.theunderseaworld.utils.OnResponseHandler;
import com.qifeng.theunderseaworld.utils.RequestHandler;
import com.qifeng.theunderseaworld.utils.RequestStatus;
import com.qifeng.theunderseaworld.utils.StatusBarCompat;
import com.qifeng.theunderseaworld.view.FlowIndicator;
import com.qifeng.theunderseaworld.view.SlideAutoLoopView;
import com.qifeng.theunderseaworld.view.SpaceItemDecoretion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AnimalKePuActivity extends AppCompatActivity {
    private final static String TAG = AnimalKePuActivity.class.getCanonicalName();
    AnimalKePuActivity mContext;

    FlowIndicator flowIndicator;

    String animalid;
    @BindView(R.id.kepu_slideAuto)
    SlideAutoLoopView slideAutoLoopView;
    @BindView(R.id.animal_text_intro)
    TextView animalTextIntro;

    String[] strPathArray;

    @BindView(R.id.animalkepudetails_recyclerView)
    RecyclerView animalkepudetailsRecyclerView;


    GridLayoutManager manager;
    AnimalButtonAdapter mAdapter;
    ArrayList<AnimalButtonBean> arraylist;
    AnimalButtonAdapter.MyClickListener mListener;
    HttpRequestWrap httpRequestWrap = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //API19以下用于沉侵式菜单栏
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_animal_ke_pu);

        //API20以上
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            //沉侵
            StatusBarCompat.compat(this, getResources().getColor(R.color.bottom_blue));
        }
        ButterKnife.bind(this);

        mContext = this;
        animalid = getIntent().getStringExtra("id");
        L.e(TAG, animalid + "");

        initView();
        initData();
    }


    private void initData() {
        downloadAnimalKePu();//下载生成选项卡的方法
        if (animalid != null) {
            downloadAnimalDetails(animalid);//通过首页动物item点击传的id下载方法
        }
    }

    @Override
    public void setContentTransitionManager(TransitionManager tm) {
        super.setContentTransitionManager(tm);
    }

    private void downloadAnimalKePu() {
        httpRequestWrap = new HttpRequestWrap(mContext);
        httpRequestWrap.setMethod(HttpRequestWrap.POST);
        httpRequestWrap.setCallBack(new RequestHandler(mContext, new OnResponseHandler() {
            @Override
            public void onResponse(String s, RequestStatus status) {
                if (status == RequestStatus.SUCCESS) {
                    if (!s.isEmpty()) {
                        JSONObject jsonObject = JSONObject.parseObject(s);
                        JSONObject j = jsonObject.getJSONObject("result");
                        JSONArray array = j.getJSONArray("retData");
                        for (int i = 0; i < array.size(); i++) {
                            AnimalButtonBean bean = new AnimalButtonBean();
                            JSONObject x = array.getJSONObject(i);
                            bean.setBtn_title(x.getString("science_title"));
                            bean.setBtn_id(x.getString("science_id"));
                            arraylist.add(bean);

                        }
                        Log.e(TAG, "arraylist==============" + arraylist.toString());
                        mAdapter.initData(arraylist);
                    }
                }
            }
        }));
        Map<String, Object> map = new HashMap<>();
        map.put("num", 10 + "");
        httpRequestWrap.send(I.SERVER_URL + "ScienceList" + I.INDEX, map);
    }

    private void downloadAnimalDetails(String strId) {
        httpRequestWrap = new HttpRequestWrap(mContext);
        httpRequestWrap.setMethod(HttpRequestWrap.POST);
        httpRequestWrap.setCallBack(new RequestHandler(mContext, new OnResponseHandler() {
            @Override
            public void onResponse(String s, RequestStatus status) {
                if (status == RequestStatus.SUCCESS) {
                    if (!s.isEmpty()) {
                        JSONObject jsonObject = JSONObject.parseObject(s);
                        JSONObject j = jsonObject.getJSONObject("result");
                        JSONArray array = j.getJSONArray("retData");
                        Log.e("error", "array====================" + array.size());
                        AnimalDetailsBean bean = new AnimalDetailsBean();
                        strPathArray = new String[array.size()];

                        for (int i = 0; i < array.size(); i++) {

                            JSONObject x = array.getJSONObject(i);
                            bean.setScienceTitle(x.getString("science_title"));
                            bean.setScienceContent(x.getString("science_content"));

                            String path = x.getString("path");
                            bean.setPath(path);
                            strPathArray[i] = path;
                        }
                        showAnimalDetails(bean);
                    }
                }
            }
        }));
        Map<String, Object> map = new HashMap<>();
        map.put("science_id", strId);
        httpRequestWrap.send(I.SERVER_URL + "ScienceDetails" + I.INDEX, map);
    }

    private void showAnimalDetails(AnimalDetailsBean details) {
        animalTextIntro.setText(details.getScienceContent());
        slideAutoLoopView.startPlayLoop(flowIndicator, strPathArray, strPathArray.length);
    }


    private void initView() {
        flowIndicator = (FlowIndicator) findViewById(R.id.kepu_flowIndicator);

        arraylist = new ArrayList<>();
        manager = new GridLayoutManager(mContext, 5, LinearLayoutManager.VERTICAL, false);
        mAdapter = new AnimalButtonAdapter(mContext, arraylist);


        mListener = new AnimalButtonAdapter.MyClickListener() {
            @Override
            public void onClick(int postion, View view) {
                //被点击的item的view，position被点击item的位置
                TextView textView = (TextView) view;

                textView.setBackground(getResources().getDrawable(R.drawable.button_no_radius_with_blue_solid));
                textView.setTextColor(getResources().getColor(R.color.white));
                AnimalButtonBean bean = arraylist.get(postion);
                downloadAnimalDetails(bean.getBtn_id());

                textView.setBackground(getResources().getDrawable(R.drawable.buttom_no_radius_with_solid));
                textView.setTextColor(getResources().getColor(R.color.bottom_blue));


            }
        };
        mAdapter.setMyListener(mListener);
        mAdapter.setId(animalid);
        animalkepudetailsRecyclerView.setLayoutManager(manager);
        animalkepudetailsRecyclerView.setAdapter(mAdapter);
        animalkepudetailsRecyclerView.setHasFixedSize(true);
        animalkepudetailsRecyclerView.addItemDecoration(new SpaceItemDecoretion(8));


    }


    @OnClick(R.id.kepu_img_back)
    public void onClick() {
        MFGT.finish(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
