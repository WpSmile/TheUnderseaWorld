package com.qifeng.theunderseaworld.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qifeng.theunderseaworld.I;
import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.bean.CartBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/10/27.
 */
public class CartAdapter extends RecyclerView.Adapter {
    Context mContext;
    ArrayList<CartBean> mlist;
    RecyclerView parent;
    boolean isMore;


    public boolean isMore() {
        return isMore;
    }

    public void setMore(boolean more) {
        this.isMore = more;
        notifyDataSetChanged();
    }

    public int getFooterString() {
        return isMore ? R.string.load_more : R.string.no_more;
    }


    public CartAdapter(Context mContext, ArrayList<CartBean> list) {
        this.mContext = mContext;
        if (mlist!=null){
            this.mlist.clear();
            this.mlist.addAll(list);
        }else {
            mlist=new ArrayList<>();
            mlist.addAll(list);
        }

    }

    public void initData(ArrayList<CartBean> cartBeenlist) {
        if (mlist != null) {
            mlist.clear();
        }
        mlist.addAll(cartBeenlist);
        //mlist = list;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.parent = (RecyclerView) parent;
        RecyclerView.ViewHolder holder = null;
        View layout = LayoutInflater.from(mContext).inflate(R.layout.item_cart, parent, false);
        holder = new CartViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final CartBean cartBean = mlist.get(position);



        ((CartViewHolder) holder).tvGoodsNum.setText(cartBean.getGoodsNum());
        ((CartViewHolder) holder).itemTvGoodsName.setText(cartBean.getGoodsTitle());
        ((CartViewHolder) holder).tvPrice.setText(cartBean.getGoodsPrice());

        //ImageLoader.downloadImg(mContext, ((CartViewHolder) holder).ivGoodsPicture, goods.getGoodsThumb());
        ((CartViewHolder) holder).itemIdCheckbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                mContext.sendBroadcast(new Intent(I.BROADCASE_UPDATE_CART));
            }
        });

        ((CartViewHolder) holder).ivAddCart.setTag(position);




    }

    @Override
    public int getItemCount() {
        return mlist == null ? 0 : mlist.size();
        //return 3;
    }


    static class CartViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.item_id_checkbox1)
        CheckBox itemIdCheckbox1;
        @BindView(R.id.iv_Cart_picture)
        ImageView ivCartPicture;
        @BindView(R.id.item_tv_goods_name)
        TextView itemTvGoodsName;
        @BindView(R.id.iv_dele_cart)
        ImageView ivDeleCart;
        @BindView(R.id.tv_goods_num)
        TextView tvGoodsNum;
        @BindView(R.id.iv_add_cart)
        ImageView ivAddCart;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        @BindView(R.id.rl_cart_item)
        RelativeLayout rlCartItem;

        public CartViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
