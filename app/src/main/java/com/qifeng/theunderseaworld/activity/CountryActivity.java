package com.qifeng.theunderseaworld.activity;


import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.seabed_state.BaseActivity;
import com.qifeng.theunderseaworld.seabed_state.StatusBarCompat;
import com.qifeng.theunderseaworld.view.CharacterParser;
import com.qifeng.theunderseaworld.view.PinyinComparator;
import com.qifeng.theunderseaworld.view.SideBar;
import com.qifeng.theunderseaworld.view.SortAdapter;
import com.qifeng.theunderseaworld.view.SortModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 国家/地区界面
 * Created by XinAiXiaoWen on 2017/3/21.
 */

public class CountryActivity extends BaseActivity implements SideBar.OnTouchingLetterChangedListener,AdapterView.OnItemClickListener,View.OnClickListener {

    //输出日志
    private String TAG = CountryActivity.class.getSimpleName();

    //上下文
    private Context countryContext = null;

    //返回
    private ImageView ivSeabedCountryReturn = null;

    //显示国家/地区
    private ListView sbSeabedCountryLvcountry;

    //右边字母显示
    private SideBar sbSeabedCountrySidrbar;

    //适配器
    private SortAdapter adapter;

    //汉转拼音
    private CharacterParser characterParser;

    //所获得的数据
    private List<SortModel> SourceDateList;

    //根据拼音来排列ListView里面的数据类
    private PinyinComparator pinyinComparator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //API19以下用于沉侵式菜单栏
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        //加载布局
        setContentView(R.layout.activity_country);

        //API>=20以上用于沉侵式菜单栏
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            //沉侵
            StatusBarCompat.compat(this, getResources().getColor(R.color.seabed_item_mall_line));
        }

        //初始化前
        initCountryAgo();

        //初始化控件
        initCountryView();

        //注册监听器
        initCountryListener();

        //适配器
        initCountryAdapter();

        //初始化后
        initCountryBack();
    }

    /**
     * 初始化前
     */
    private void initCountryAgo(){
        //上下文
        countryContext = this;
        characterParser = CharacterParser.getInstance();
        pinyinComparator = new PinyinComparator();
        //初始化数据
        SourceDateList = filledData(getResources().getStringArray(R.array.date));
        Collections.sort(SourceDateList, pinyinComparator);
    }

    /**
     * 初始化控件
     */
    private void initCountryView(){
        //返回
        ivSeabedCountryReturn = (ImageView) this.findViewById(R.id.iv_seabed_country_return);
        //右边字母控件
        sbSeabedCountrySidrbar = (SideBar) this.findViewById(R.id.sb_seabed_country_sidrbar);
        //国家集合控件
        sbSeabedCountryLvcountry = (ListView) this.findViewById(R.id.sb_seabed_country_lvcountry);
    }

    /**
     * 注册监听器
     */
    private void initCountryListener(){
        //返回监听器
        ivSeabedCountryReturn.setOnClickListener(this);
        //右边字母控件
        sbSeabedCountrySidrbar.setOnTouchingLetterChangedListener(this);
        //国家集合控件
        sbSeabedCountryLvcountry.setOnItemClickListener(this);
    }

    /**
     * 适配器
     */
    private void initCountryAdapter(){
        //国家适配器
        adapter = new SortAdapter(this, SourceDateList);
        //绑定适配器
        sbSeabedCountryLvcountry.setAdapter(adapter);
    }

    /**
     * 初始化后
     */
    private void initCountryBack(){

    }

    /**
     * 初始化数据
     * @param date
     * @return
     */
    private List<SortModel> filledData(String [] date){
        List<SortModel> mSortList = new ArrayList<SortModel>();

        for(int i=0; i<date.length; i++){
            SortModel sortModel = new SortModel();
            sortModel.setName(date[i]);
            String pinyin = characterParser.getSelling(date[i]);
            String sortString = pinyin.substring(0, 1).toUpperCase();
            if(sortString.matches("[A-Z]")){
                sortModel.setSortLetters(sortString.toUpperCase());
            }else{
                sortModel.setSortLetters("#");
            }
            mSortList.add(sortModel);
        }
        return mSortList;
    }

    /**
     * 响应监听事件
     * @param v
     */
    @Override
    public void onClick(View v) {
            switch(v.getId()){
                //返回
                case R.id.iv_seabed_country_return:
                    finish();
                    break;
            }
    }

    @Override
    public void onTouchingLetterChanged(String s) {
        int position = adapter.getPositionForSection(s.charAt(0));
        if(position != -1){
            sbSeabedCountryLvcountry.setSelection(position);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplication(), ((SortModel)adapter.getItem(position)).getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "---启动---");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "---恢复---");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "---暂停---");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "---停止---");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "---重启---");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "---销毁---");
    }
}
