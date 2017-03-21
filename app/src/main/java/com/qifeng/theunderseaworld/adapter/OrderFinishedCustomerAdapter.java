package com.qifeng.theunderseaworld.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.bean.OrderManagementBean;
import com.qifeng.theunderseaworld.bean.PingjiaCustomerBean;
import com.qifeng.theunderseaworld.view.ImageViewPlus;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 评价系统（客户端）的适配器
 */

public class OrderFinishedCustomerAdapter extends RecyclerView.Adapter {
    Context mContext;
    //用于存放item的集合
    ArrayList<OrderManagementBean> PingjiaCustomerList;

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

    public OrderFinishedCustomerAdapter() {

    }


    public OrderFinishedCustomerAdapter(Context mContext, ArrayList<OrderManagementBean> todayActivityList) {
        this.mContext = mContext;
        this.PingjiaCustomerList = todayActivityList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.parent = (RecyclerView) parent;
        RecyclerView.ViewHolder holder = null;
        View layout = null;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        layout = inflater.inflate(R.layout.item_order_manager_avtivity, parent, false);
        holder = new PingjiaCustomerViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        /*if (holder instanceof PingjiaCustomerViewHolder) {
            TodayActivityBean todayActivityBean = todayActivityList.get(position);
            ((PingjiaCustomerViewHolder) holder).todayActivityTitle.setText(todayActivityBean.getTitle());
            ImageLoader.downloadImg(mContext, ((PingjiaCustomerViewHolder) holder).todayActivityIamge, todayActivityBean.getImageurl());
            ((PingjiaCustomerViewHolder) holder).itemTodayActivityRl.setTag(todayActivityBean.getId());
            L.e("id:" + todayActivityBean.getId());
        }*/
    }

    @Override
    public int getItemCount() {
        return PingjiaCustomerList == null ? 1 : PingjiaCustomerList.size() + 1;
    }


    public void initData(ArrayList list) {
        if (PingjiaCustomerList != null) {
            PingjiaCustomerList.clear();
        }
        PingjiaCustomerList.addAll(list);
        notifyDataSetChanged();
    }

    public void addData(ArrayList list) {
        PingjiaCustomerList.addAll(list);
        notifyDataSetChanged();
    }



    class PingjiaCustomerViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_pingjia_system_customer_customer_ivp_avatar)
        ImageViewPlus itemPingjiaSystemCustomerCustomerIvpAvatar;
        @BindView(R.id.item_pingjia_system_customer_customer_btn_grade05)
        TextView itemPingjiaSystemCustomerCustomerBtnGrade05;
        @BindView(R.id.item_pingjia_system_customer_customer_tv_time)
        TextView itemPingjiaSystemCustomerCustomerTvTime;
        @BindView(R.id.item_pingjia_system_customer_customer_tv_nick)
        TextView itemPingjiaSystemCustomerCustomerTvNick;
        @BindView(R.id.item_pingjia_system_customer_customer_tv)
        TextView itemPingjiaSystemCustomerCustomerTv;
        @BindView(R.id.item_pingjia_system_customer_image_first)
        ImageView itemPingjiaSystemCustomerImageFirst;
        @BindView(R.id.item_pingjia_system_customer_image_item_add)
        ImageView itemPingjiaSystemCustomerImageItemAdd;
        @BindView(R.id.item_pingjia_system_customer_image_item_add1)
        ImageView itemPingjiaSystemCustomerImageItemAdd1;

        public PingjiaCustomerViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }


        @OnClick(R.id.item_pingjia_system_customer_rl_customer)
        public void onClick() {
        }
    }
}
