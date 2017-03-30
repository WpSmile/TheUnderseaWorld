package com.qifeng.theunderseaworld.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.activity.DetailsActivity;
import com.qifeng.theunderseaworld.bean.CartTuijianBean;
import com.qifeng.theunderseaworld.utils.MFGT;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/10/27.
 */
public class HomeTuijianAdapter extends RecyclerView.Adapter {
    Context mContext;
    ArrayList<CartTuijianBean> mlist;
    RecyclerView parent;



    public HomeTuijianAdapter(Context mContext, ArrayList<CartTuijianBean> list) {
        this.mContext = mContext;

        if (mlist!=null){
            this.mlist.clear();
            this.mlist.addAll(list);
        }else {
            mlist=new ArrayList<>();
            mlist.addAll(list);
        }

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.parent = (RecyclerView) parent;
        RecyclerView.ViewHolder holder = null;
        View layout = LayoutInflater.from(mContext).inflate(R.layout.item_home_tuijian, parent, false);
        holder = new CartViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CartTuijianBean cartTuijianBean = mlist.get(position);


        ((CartViewHolder) holder).tvItemTuijianTitle.setText(cartTuijianBean.getGoodsTitle());

        //((CartViewHolder) holder).tvTuijianTicket.setText(cartTuijianBean.getGoodsId());
        ((CartViewHolder) holder).tvTuijianPrice.setText("￥"+cartTuijianBean.getGoodsPrice());
        //ImageLoader.downloadImg(mContext, ((CartViewHolder) holder).ivGoodsPicture, goods.getGoodsThumb());

        ((CartViewHolder)holder).llItemHomeTuijian.setTag(cartTuijianBean.getGoodsId());

    }

    @Override
    public int getItemCount() {
        return mlist == null ? 0 : mlist.size();
    }

    public void initData(ArrayList<CartTuijianBean> hometuijianlist) {
        if (mlist != null) {
            mlist.clear();
        }
        mlist.addAll(hometuijianlist);
        notifyDataSetChanged();
    }


    class CartViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_item_tuijian)
        ImageView imgItemTuijian;
        @BindView(R.id.tv_item_tuijian_title)
        TextView tvItemTuijianTitle;
        @BindView(R.id.tv_tuijian_ticket)
        TextView tvTuijianTicket;
        @BindView(R.id.tv_tuijian_price)
        TextView tvTuijianPrice;
        @BindView(R.id.ll_item_home_tuijian)
        LinearLayout llItemHomeTuijian;

        public CartViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @OnClick(R.id.ll_item_home_tuijian)
        public void onClick() {
            String id = (String) llItemHomeTuijian.getTag();
            MFGT.gotoDetailsActivity(mContext,id);
        }

    }
}
