package com.qifeng.theunderseaworld.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.qifeng.theunderseaworld.I;
import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.bean.CartTuijianBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/10/27.
 */
public class CartTuijianAdapter extends RecyclerView.Adapter {
    Context mContext;
    ArrayList<CartTuijianBean> mlist;
    RecyclerView parent;



    public CartTuijianAdapter(Context mContext, ArrayList<CartTuijianBean> list) {
        this.mContext = mContext;
        if (mlist!=null){
            this.mlist.clear();
            this.mlist.addAll(list);
        }else {
            mlist=new ArrayList<>();
            mlist.addAll(list);
        }

    }

    public void initData(ArrayList<CartTuijianBean> list) {
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
        RecyclerView.ViewHolder holder = null;
        View layout = LayoutInflater.from(mContext).inflate(R.layout.item_cart_second, parent, false);
        holder = new CartViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CartTuijianBean bean = mlist.get(position);
        ((CartViewHolder) holder).tvItemSencondCartTitle.setText(bean.getGoodsTitle());

        ((CartViewHolder) holder).tvSencondPrice.setText("("+bean.getGoodsPrice()+")");
        //ImageLoader.downloadImg(mContext, ((CartViewHolder) holder).ivGoodsPicture, goods.getGoodsThumb());



    }

    @Override
    public int getItemCount() {
        return 3;
    }




    class CartViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_item_second_cart)
        ImageView imgItemSecondCart;
        @BindView(R.id.tv_item_sencond_cart_title)
        TextView tvItemSencondCartTitle;
        @BindView(R.id.tv_ticket)
        TextView tvTicket;
        @BindView(R.id.tv_sencond_price)
        TextView tvSencondPrice;

        public CartViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @OnClick(R.id.ll_item_second_cart)
        public void onClick() {//跳转至商品详情

        }
    }
}
