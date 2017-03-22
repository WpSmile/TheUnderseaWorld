package com.qifeng.theunderseaworld.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.bean.PersonalCustomerTuijianBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的（客户端）推荐
 * Created by Administrator on 2016/10/27.
 */
public class PersinalCustomerTuijianAdapter extends RecyclerView.Adapter {
    Context mContext;
    ArrayList<PersonalCustomerTuijianBean> mlist;
    RecyclerView parent;



    public PersinalCustomerTuijianAdapter(Context mContext, ArrayList<PersonalCustomerTuijianBean> list) {
        this.mContext = mContext;
        this.mlist = list;

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

        /*((PersonalCustomerTuijianViewHolder) holder).tvGoodsNum.setText("(" + cartBean.getCount() + ")");

        ((PersonalCustomerTuijianViewHolder) holder).tvGoodsName.setText(goods.getGoodsName());
        ((PersonalCustomerTuijianViewHolder) holder).tvprice.setText(goods.getCurrencyPrice());
        ((PersonalCustomerTuijianViewHolder) holder).idCheckbox1.setChecked(cartBean.isChecked());
        ImageLoader.downloadImg(mContext, ((PersonalCustomerTuijianViewHolder) holder).ivGoodsPicture, goods.getGoodsThumb());
        ((PersonalCustomerTuijianViewHolder) holder).idCheckbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                cartBean.setChecked(b);
                mContext.sendBroadcast(new Intent(I.BROADCASE_UPDATE_CART));
            }
        });

        ((PersonalCustomerTuijianViewHolder) holder).ivAddCart.setTag(position);*/


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
        }

    }
}
