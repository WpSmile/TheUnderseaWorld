package com.qifeng.theunderseaworld.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;


import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.seabed_state.SeabedViewHolder;

/**
 * 商品管理适配器
 * Created by XinAiXiaoWen on 2017/3/22.
 */

public class WareAdapter extends BaseAdapter {

    private Context wareContext = null;

    public WareAdapter(Context wareContext) {
        this.wareContext = wareContext;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SeabedViewHolder seabedViewHolder = null;
        if(convertView == null) {
            convertView = LayoutInflater.from(wareContext).inflate(R.layout.item_ware, null);
            seabedViewHolder = new SeabedViewHolder();
            //商品图
            seabedViewHolder.ivSeabedWareImage = (ImageView) convertView.findViewById(R.id.iv_seabed_ware_image);
            //商家
            seabedViewHolder.tvSeabedWareTicket = (TextView) convertView.findViewById(R.id.tv_seabed_ware_ticket);
            //来自
            seabedViewHolder.tvSeabedWareFrom = (TextView) convertView.findViewById(R.id.tv_seabed_ware_from);
            //钱
            seabedViewHolder.tvSeabedWareMoney = (TextView) convertView.findViewById(R.id.tv_seabed_ware_money);
            //减
            seabedViewHolder.ivSeabedWareMinus = (ImageView) convertView.findViewById(R.id.iv_seabed_ware_minus);
            //数量
            seabedViewHolder.tvSseabedWareNumber = (TextView) convertView.findViewById(R.id.tv_seabed_ware_number);
            //加
            seabedViewHolder.ivSeabedWareAdd = (ImageView) convertView.findViewById(R.id.iv_seabed_ware_add);
            //选择
            seabedViewHolder.cbSeabedWareSelete = (CheckBox) convertView.findViewById(R.id.cb_seabed_ware_selete);
            //复用
            convertView.setTag(seabedViewHolder);
        } else {
            seabedViewHolder = (SeabedViewHolder) convertView.getTag();
        }
        return convertView;
    }
}
