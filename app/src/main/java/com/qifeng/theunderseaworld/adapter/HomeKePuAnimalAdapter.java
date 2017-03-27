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
import com.qifeng.theunderseaworld.utils.ImageLoader;
import com.qifeng.theunderseaworld.utils.L;
import com.qifeng.theunderseaworld.utils.MFGT;
import com.qifeng.theunderseaworld.utils.OkImageLoader;
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
    ArrayList<HomeKePuAnimalBean> mList;

    RecyclerView parent;


    public HomeKePuAnimalAdapter(Context mContext, ArrayList<HomeKePuAnimalBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
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
        if (holder instanceof HomeKepuAnimalViewHolder) {
            HomeKePuAnimalBean bean = mList.get(position);

            ((HomeKepuAnimalViewHolder) holder).homeItemName.setText(bean.getScienceTitle());
            //ImageLoader.downloadImg(mContext,((HomeKepuAnimalViewHolder)holder).itemAnimalImage,bean.getGoodsThumb());
            ((HomeKepuAnimalViewHolder) holder).homeItemRtv.setText(bean.getScienceEnglishTitle());


            ((HomeKepuAnimalViewHolder) holder).itemRlAnimal.setTag(bean.getScienceId());
            L.e("id:" + bean.getScienceId());

        }
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public void initData(ArrayList<HomeKePuAnimalBean> kePuAnimallist) {
        if (mList != null) {
            mList.clear();
        }
        mList.addAll(kePuAnimallist);
        notifyDataSetChanged();
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
            int id = (int) itemRlAnimal.getTag();

            MFGT.gotoAnimalKePuActivity((Activity) mContext,id);
        }
    }
}
