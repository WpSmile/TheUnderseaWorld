package com.qifeng.theunderseaworld.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.bean.HomeKePuAnimalBean;
import com.qifeng.theunderseaworld.utils.MFGT;
import com.qifeng.theunderseaworld.view.RotateTextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 首页科普类动物的adapter
 */

public class HomeKePuAnimalAdapter extends RecyclerView.Adapter {
    Context mContext;
    //用于存放item的集合
    ArrayList<HomeKePuAnimalBean> todayActivityList;

    RecyclerView parent;


    public HomeKePuAnimalAdapter(Context mContext, ArrayList<HomeKePuAnimalBean> todayActivityList) {
        this.mContext = mContext;
        this.todayActivityList = todayActivityList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.parent = (RecyclerView) parent;
        RecyclerView.ViewHolder holder = null;
        View layout = LayoutInflater.from(mContext).inflate(R.layout.home_item_animal, parent, false);
        holder = new HomeKepuAnimalViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        /*if (holder instanceof HomeKepuAnimalViewHolder) {
            HomeKePuAnimalBean bean = new HomeKePuAnimalBean();
            ((HomeKepuAnimalViewHolder) holder).homeItemName.setText(bean.getName());
            ImageLoader.downloadImg(mContext,((HomeKepuAnimalViewHolder) holder).itemAnimalImage,bean.getIamgeurl());
            ((HomeKepuAnimalViewHolder) holder).itemRlAnimal.setTag(bean.getId());
            L.e("id:" + bean.getId());
        }*/
    }

    @Override
    public int getItemCount() {
        return 4;
    }




    class HomeKepuAnimalViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_animal_image)
        ImageView itemAnimalImage;
        @BindView(R.id.home_item_rtv)
        RotateTextView homeItemRtv;
        @BindView(R.id.home_item_name)
        TextView homeItemName;
        @BindView(R.id.item_rl_animal)
        RelativeLayout itemRlAnimal;

        public HomeKepuAnimalViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            homeItemRtv.setDegrees(90);
        }
        @OnClick(R.id.item_rl_animal)
        public void onClick() {
            MFGT.gotoAnimalKePuActivity((Activity) mContext);
        }
    }
}
