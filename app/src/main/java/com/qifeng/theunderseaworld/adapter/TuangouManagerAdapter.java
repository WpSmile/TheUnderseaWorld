package com.qifeng.theunderseaworld.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.bean.TuangouManagerBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by liu on 2017/3/23.
 */

public class TuangouManagerAdapter extends RecyclerView.Adapter {

    ArrayList<TuangouManagerBean> mlist;
    Context context;

    RecyclerView parent;

    public TuangouManagerAdapter(ArrayList<TuangouManagerBean> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.parent = (RecyclerView) parent;
        RecyclerView.ViewHolder holder;
        View layout = LayoutInflater.from(context).inflate(R.layout.item_tuangou_manager, parent, false);
        holder = new TuangouManagerViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mlist == null ? 1 : mlist.size() + 1;
    }


    static class TuangouManagerViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_tuangou_manager_iamge)
        ImageView itemTuangouManagerIamge;
        @BindView(R.id.item_tuangou_manager_tv_title)
        TextView itemTuangouManagerTvTitle;
        @BindView(R.id.item_tuangou_manager_tv_sign)
        TextView itemTuangouManagerTvSign;
        @BindView(R.id.item_tuangou_manager_tv_price)
        TextView itemTuangouManagerTvPrice;
        @BindView(R.id.reply_tv_num)
        TextView replyTvNum;

        public TuangouManagerViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }


        @OnClick(R.id.item_tuangou_manager_rl)
        public void onViewClicked() {
        }
    }
}
