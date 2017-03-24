package com.qifeng.theunderseaworld.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;


import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.adapter.WareAdapter;

/**
 * 销售中
 * Created by XinAiXiaoWen on 2017/3/21.
 */

public class SellFragment extends Fragment implements View.OnClickListener,AdapterView.OnItemClickListener{

    //输出日志
    private String TAG = SellFragment.class.getSimpleName();

    //销售控件
    private View sell;

    //商品下架
    private TextView tvSeabedSellCarriage = null;

    //商品列表
    private ListView lvSeabedSellList = null;

    //商品列表适配器
    private WareAdapter wareAdapter = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //销售控件加载
        sell = inflater.inflate(R.layout.fragment_sell,null);

        initSellAgo();

        initSellView();

        initSellListener();

        initSellAdapter();

        initSellBack();
        return sell;
    }

    private void initSellAgo(){

    }

    private void initSellView(){
        //商品下架
        tvSeabedSellCarriage = (TextView) sell.findViewById(R.id.tv_seabed_sell_carriage);
        //商品列表
        lvSeabedSellList = (ListView) sell.findViewById(R.id.lv_seabed_sell_list);
    }

    private void initSellListener(){
        //商品下架注册监听
        tvSeabedSellCarriage.setOnClickListener(this);
        //商品列表注册监听
        lvSeabedSellList.setOnItemClickListener(this);
    }

    private void initSellAdapter(){
        wareAdapter = new WareAdapter(getActivity());
        lvSeabedSellList.setAdapter(wareAdapter);
    }

    private void initSellBack(){

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //商品下架
            case R.id.tv_seabed_sell_carriage:
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
