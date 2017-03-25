package com.qifeng.theunderseaworld.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qifeng.theunderseaworld.R;
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
        this.mlist = list;

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

        /*((CartViewHolder) holder).tvGoodsNum.setText("(" + cartBean.getCount() + ")");

        ((CartViewHolder) holder).tvGoodsName.setText(goods.getGoodsName());
        ((CartViewHolder) holder).tvprice.setText(goods.getCurrencyPrice());
        ((CartViewHolder) holder).idCheckbox1.setChecked(cartBean.isChecked());
        ImageLoader.downloadImg(mContext, ((CartViewHolder) holder).ivGoodsPicture, goods.getGoodsThumb());
        ((CartViewHolder) holder).idCheckbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                cartBean.setChecked(b);
                mContext.sendBroadcast(new Intent(I.BROADCASE_UPDATE_CART));
            }
        });

        ((CartViewHolder) holder).ivAddCart.setTag(position);*/


    }

    @Override
    public int getItemCount() {
        return 3;
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
        public CartViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
        @OnClick(R.id.ll_item_home_tuijian)
        public void onClick() {
            MFGT.gotoDetailsActivity(mContext);
        }

    }
}
