package com.qifeng.theunderseaworld.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qifeng.theunderseaworld.I;
import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.bean.TodayActivityBean;
import com.qifeng.theunderseaworld.utils.ImageLoader;
import com.qifeng.theunderseaworld.utils.L;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 今日活动的适配器
 */

public class TodayActivityAdapter extends RecyclerView.Adapter {
    Context mContext;
    //用于存放item的集合
    ArrayList<TodayActivityBean> todayActivityList;

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

    public TodayActivityAdapter() {

    }

    public TodayActivityAdapter(Context mContext, ArrayList<TodayActivityBean> todayActivityList) {
        this.mContext = mContext;
        this.todayActivityList = todayActivityList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.parent = (RecyclerView) parent;
        RecyclerView.ViewHolder holder = null;
        View layout = null;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        switch (viewType) {
            case I.TYPE_FOOTER:
                layout = inflater.inflate(R.layout.item_footer, parent, false);
                holder = new FooterViewHolder(layout);
                break;
            case I.TYPE_ITEM:
                layout = inflater.inflate(R.layout.item_today_avtivity, parent, false);
                holder = new TodayActivityViewHolder(layout);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof FooterViewHolder) {
            ((FooterViewHolder) holder).tvFooter.setText(getFooterString());
        }
        if (holder instanceof TodayActivityViewHolder) {
            TodayActivityBean todayActivityBean = todayActivityList.get(position);
            ((TodayActivityViewHolder) holder).todayActivityTitle.setText(todayActivityBean.getTitle());
            ImageLoader.downloadImg(mContext, ((TodayActivityViewHolder) holder).todayActivityIamge, todayActivityBean.getImageurl());
            ((TodayActivityViewHolder) holder).itemTodayActivityRl.setTag(todayActivityBean.getId());
            L.e("id:" + todayActivityBean.getId());
        }
    }

    @Override
    public int getItemCount() {
        return todayActivityList == null ? 1 : todayActivityList.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1) {
            return I.TYPE_FOOTER;
        } else {
            return I.TYPE_ITEM;
        }
    }

    public void initData(ArrayList list) {
        if (todayActivityList != null) {
            todayActivityList.clear();
        }
        todayActivityList.addAll(list);
        notifyDataSetChanged();
    }

    public void addData(ArrayList list) {
        todayActivityList.addAll(list);
        notifyDataSetChanged();
    }

    class FooterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvFooter)
        TextView tvFooter;

        public FooterViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    class TodayActivityViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.today_activity_iamge)
        ImageView todayActivityIamge;
        @BindView(R.id.today_activity_title)
        TextView todayActivityTitle;
        @BindView(R.id.today_activity_sign)
        TextView todayActivitySign;
        @BindView(R.id.today_text_price)
        TextView todayTextPrice;
        @BindView(R.id.today_activity_bao)
        ImageView todayActivityBao;
        @BindView(R.id.item_today_activity_rl)
        RelativeLayout itemTodayActivityRl;

        public TodayActivityViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @OnClick(R.id.item_today_activity_rl)
        public void onClick() {

        }
    }
}
