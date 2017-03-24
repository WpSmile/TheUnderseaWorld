package com.qifeng.theunderseaworld.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.seabed_state.SeabedViewHolder;
import com.qifeng.theunderseaworld.view.CircleImageView;

/**
 * 留言集合适配器
 * Created by XinAiXiaoWen on 2017/3/20.
 */

public class DetailsAdapter extends BaseAdapter {

    private Context detailsContext = null;

    public DetailsAdapter(Context detailsContext) {
        this.detailsContext = detailsContext;
    }

    @Override
    public int getCount() {
        return 4;
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
        if(convertView == null){
            //加载布局
            convertView = LayoutInflater.from(detailsContext).inflate(R.layout.item_details,null);
            //实例化万能适配器
            seabedViewHolder = new SeabedViewHolder();
            //头像
            seabedViewHolder.ciSeabedDetailsItemHead = (CircleImageView) convertView.findViewById(R.id.ci_seabed_details_item_head);
            //姓名
            seabedViewHolder.tvSeabedDetailsItemName = (TextView) convertView.findViewById(R.id.tv_seabed_details_item_name);
            //日期
            seabedViewHolder.tvSeabedDetailsItemDate = (TextView) convertView.findViewById(R.id.tv_seabed_details_item_date);
            //留言内容
            seabedViewHolder.tvSeabedDetailsItemContext = (TextView) convertView.findViewById(R.id.tv_seabed_details_item_context);
            //保存
            convertView.setTag(seabedViewHolder);
        } else {
            //复用
            seabedViewHolder = (SeabedViewHolder) convertView.getTag();
        }
        return convertView;
    }
}
