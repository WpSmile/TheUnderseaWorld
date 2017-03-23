package com.qifeng.theunderseaworld.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.bean.PingjiaBusinessBean;
import com.qifeng.theunderseaworld.utils.CommonUtils;
import com.qifeng.theunderseaworld.utils.L;
import com.qifeng.theunderseaworld.utils.MFGT;
import com.qifeng.theunderseaworld.view.ImageViewPlus;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 评价系统（客户端）的适配器
 */

public class PingjiaBusinessAdapter extends RecyclerView.Adapter {
    Context mContext;
    //用于存放item的集合
    ArrayList<PingjiaBusinessBean> PingjiaCustomerList;

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

    public PingjiaBusinessAdapter() {

    }


    public PingjiaBusinessAdapter(Context mContext, ArrayList<PingjiaBusinessBean> todayActivityList) {
        this.mContext = mContext;
        this.PingjiaCustomerList = todayActivityList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.parent = (RecyclerView) parent;
        RecyclerView.ViewHolder holder = null;
        View layout = null;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        layout = inflater.inflate(R.layout.item_pingjia_system_business, parent, false);
        holder = new PingjiaBusinessViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        /*if (holder instanceof PingjiaBusinessViewHolder) {
            TodayActivityBean todayActivityBean = todayActivityList.get(position);
            ((PingjiaBusinessViewHolder) holder).todayActivityTitle.setText(todayActivityBean.getTitle());
            ImageLoader.downloadImg(mContext, ((PingjiaBusinessViewHolder) holder).todayActivityIamge, todayActivityBean.getImageurl());
            ((PingjiaBusinessViewHolder) holder).itemTodayActivityRl.setTag(todayActivityBean.getId());
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




    class PingjiaBusinessViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_pingjia_system_business_image_avatar)
        ImageViewPlus itemPingjiaSystemBusinessImageAvatar;
        @BindView(R.id.item_pingjia_system_business_tv_nick)
        TextView itemPingjiaSystemBusinessTvNick;
        @BindView(R.id.item_pingjia_system_business_tv_time)
        TextView itemPingjiaSystemBusinessTvTime;
        @BindView(R.id.item_pingjia_system_business_btn_grade05)
        TextView itemPingjiaSystemBusinessBtnGrade05;
        @BindView(R.id.item_pingjia_system_business_tv)
        TextView itemPingjiaSystemBusinessTv;

        public PingjiaBusinessViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }

        @OnClick({R.id.item_pinglun_rl_huifu, R.id.item_pinglun_rl_delete, R.id.item_pingjia_system_rl_business})
        public void onViewClicked(View view) {
            switch (view.getId()) {
                case R.id.item_pinglun_rl_huifu://回复
                    MFGT.gotoReplyActivity(mContext);
                    break;
                case R.id.item_pinglun_rl_delete://删除
                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    builder.setMessage("是否删除该条评论")
                            .setPositiveButton("删除", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    L.e("===================删除评论成功");
                                    CommonUtils.showShortToast("删除成功");
                                }
                            }).setNegativeButton("返回", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            L.e("===================已返回");
                        }
                    }).create().show();
                    break;
                case R.id.item_pingjia_system_rl_business:
                    break;
            }
        }
    }
}
