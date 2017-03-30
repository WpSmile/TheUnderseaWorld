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

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的（客户端）推荐
 * Created by Administrator on 2016/10/27.
 */
public class PersinalCustomerTuijianAdapter extends RecyclerView.Adapter {
    static Context mContext;
    ArrayList<CartTuijianBean> mlist;
    RecyclerView parent;


    public PersinalCustomerTuijianAdapter(Context mContext, ArrayList<CartTuijianBean> list) {
        this.mContext = mContext;
        this.mlist = list;

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
        View layout = LayoutInflater.from(mContext).inflate(R.layout.item_personal_customer_tuijian, parent, false);
        holder = new PersonalCustomerTuijianViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        CartTuijianBean bean = mlist.get(position);
        ((PersonalCustomerTuijianViewHolder) holder).itemPersonalCustomerTitle.setText(bean.getGoodsTitle());
        ((PersonalCustomerTuijianViewHolder) holder).itemPersonalCustomerTextPrice.setText(bean.getGoodsPrice());
        //ImageLoader.downloadImg(mContext, ((PersonalCustomerTuijianViewHolder) holder).ivGoodsPicture, goods.getGoodsThumb());


    }

    @Override
    public int getItemCount() {
        return mlist == null ? 1 : mlist.size() + 1;
    }


    class PersonalCustomerTuijianViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_personal_customer_title)
        TextView itemPersonalCustomerTitle;
        @BindView(R.id.item_personal_customer_sign)
        TextView itemPersonalCustomerSign;
        @BindView(R.id.item_personal_customer_text_price)
        TextView itemPersonalCustomerTextPrice;
        @BindView(R.id.item_personal_customer_iamge)
        ImageView itemPersonalCustomerIamge;
        @BindView(R.id.item_personal_customer_percent)
        TextView itemPersonalCustomerPercent;

        public PersonalCustomerTuijianViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @OnClick(R.id.item_personal_customer_tuijian)
        public void onClick() {//
            //MFGT.gotoDetailsActivity(mContext);
        }

    }
}
