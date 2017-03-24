package com.qifeng.theunderseaworld.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.seabed_state.SeabedState;
import com.qifeng.theunderseaworld.seabed_state.SeabedViewHolder;

/**
 * Created by XinAiXiaoWen on 2017/3/16.
 */

public class MallAdapter extends BaseAdapter {

    private Context mallContext = null;

    private SeabedState seabedState = SeabedState.getSeabedState();

    public MallAdapter(Context mallContext) {
        this.mallContext = mallContext;
    }

    @Override
    public int getCount() {
        return 10;
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
        if (convertView == null) {
            convertView = LayoutInflater.from(mallContext).inflate(R.layout.item_mall, null);
            seabedViewHolder = new SeabedViewHolder();
            //图片
            seabedViewHolder.ivSeabedItemMallImage = (ImageView) convertView.findViewById(R.id.iv_seabed_item_mall_image);
            //景区
            seabedViewHolder.tvSeabedItemMallName = (TextView) convertView.findViewById(R.id.tv_seabed_item_mall_name);
            //票种
            seabedViewHolder.tvSeabedItemMallTicket = (TextView) convertView.findViewById(R.id.tv_seabed_item_mall_ticket);
            //钱
            seabedViewHolder.tvSeabedItemMallMoney = (TextView) convertView.findViewById(R.id.tv_seabed_item_mall_money);
            convertView.setTag(seabedViewHolder);
        } else {
            seabedViewHolder = (SeabedViewHolder) convertView.getTag();
        }
        return convertView;
    }
}
