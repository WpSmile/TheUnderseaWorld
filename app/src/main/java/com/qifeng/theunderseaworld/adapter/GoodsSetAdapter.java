package com.qifeng.theunderseaworld.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.bean.GoodsSetBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 商品设置的适配器
 * Created by liu on 2017/3/23.
 */

public class GoodsSetAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<GoodsSetBean> mlist;

    RecyclerView parent;


    public GoodsSetAdapter(ArrayList<GoodsSetBean> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
    }

    public void initData(ArrayList<GoodsSetBean> list) {
        if (mlist != null) {
            mlist.clear();
        }
        mlist.addAll(list);
        //mlist = list;
        notifyDataSetChanged();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.parent = (RecyclerView) parent;
        RecyclerView.ViewHolder holder;
        View layout = LayoutInflater.from(context).inflate(R.layout.item_goods_set, parent, false);
        holder = new GoodsSetViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mlist == null ? 1 : mlist.size() + 1;
    }


    class GoodsSetViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_goods_set_image)
        ImageView itemGoodsSetImage;
        @BindView(R.id.item_goods_set_name_title)
        TextView itemGoodsSetNameTitle;
        @BindView(R.id.item_goods_set_shop_name_title)
        TextView itemGoodsSetShopNameTitle;
        @BindView(R.id.item_goods_set_price_title)
        TextView itemGoodsSetPriceTitle;
        @BindView(R.id.item_goods_set_kucun_name_title)
        TextView itemGoodsSetKucunNameTitle;
        @BindView(R.id.item_goods_set_rl)
        RelativeLayout itemGoodsSetRl;

        public GoodsSetViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
