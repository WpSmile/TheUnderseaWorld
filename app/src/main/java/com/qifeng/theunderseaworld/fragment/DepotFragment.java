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
 * 仓库中
 * Created by XinAiXiaoWen on 2017/3/21.
 */

public class DepotFragment extends Fragment implements View.OnClickListener,AdapterView.OnItemClickListener{

    //输出日志
    private String TAG = DepotFragment.class.getSimpleName();

    //仓库组件
    private View depot = null;

    //商品下架
    private TextView tvSeabedDepotCarriage = null;

    //商品列表
    private ListView lvSeabedDepotList = null;

    //商品列表适配器
    private WareAdapter wareAdapter = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //销售控件加载
        depot = inflater.inflate(R.layout.fragment_depot,null);

        initDepotAgo();

        initDepotView();

        initDepotListener();

        initDepotAdapter();

        initDepotBack();
        return depot;
    }

    private void initDepotAgo(){

    }

    private void initDepotView(){
        //商品下架
        tvSeabedDepotCarriage = (TextView) depot.findViewById(R.id.tv_seabed_depot_carriage);
        //商品列表
        lvSeabedDepotList = (ListView) depot.findViewById(R.id.lv_seabed_depot_list);
    }

    private void initDepotListener(){
        //商品下架注册监听
        tvSeabedDepotCarriage.setOnClickListener(this);
        //商品列表注册监听
        lvSeabedDepotList.setOnItemClickListener(this);
    }

    private void initDepotAdapter(){
        wareAdapter = new WareAdapter(getActivity());
        lvSeabedDepotList.setAdapter(wareAdapter);
    }

    private void initDepotBack(){

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //商品下架
            case R.id.tv_seabed_depot_carriage:
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
