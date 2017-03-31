package com.qifeng.theunderseaworld.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.bean.AnimalButtonBean;
import com.qifeng.theunderseaworld.bean.MessageEvent;

import org.greenrobot.eventbus.EventBus;

import java.net.InterfaceAddress;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by liu on 2017/3/29.
 */

public class AnimalButtonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context mContext;
    ArrayList<AnimalButtonBean> arrayList;
    RecyclerView parent;
    MyClickListener mListener;
    String id;


    public AnimalButtonAdapter(Context mContext, ArrayList<AnimalButtonBean> List) {
        this.mContext = mContext;
        if (arrayList != null) {
            this.arrayList.clear();
            this.arrayList.addAll(List);
        } else {
            arrayList = new ArrayList<>();
            arrayList.addAll(List);
        }
    }

    public void setId(String animalid) {
        this.id = animalid;
    }

    public void setMyListener(MyClickListener listener) {
        this.mListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.parent = (RecyclerView) parent;
        RecyclerView.ViewHolder holder = null;
        View layout = LayoutInflater.from(mContext).inflate(R.layout.item_animal_button, parent, false);
        holder = new AnimalButtonViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AnimalButtonBean bean = arrayList.get(position);
        ((AnimalButtonViewHolder) holder).animalDetailsBtn.setText(bean.getBtn_title());

        mListener.onClick(position, ((AnimalButtonViewHolder) holder).animalDetailsBtn);
        //((AnimalButtonViewHolder) holder).animalDetailsBtn.setBackground(mContext.getResources().getDrawable(R.drawable.button_no_radius_with_blue_solid));
        //((AnimalButtonViewHolder) holder).animalDetailsBtn.setTextColor(mContext.getResources().getColor(R.color.white));

        ((AnimalButtonViewHolder) holder).animalDetailsBtn.setBackground(mContext.getResources().getDrawable(R.drawable.buttom_no_radius_with_solid));
        ((AnimalButtonViewHolder) holder).animalDetailsBtn.setTextColor(mContext.getResources().getColor(R.color.bottom_blue));


        ((AnimalButtonViewHolder) holder).animalDetailsBtn.setTag(bean.getBtn_id());
    }

    @Override
    public int getItemCount() {
        return arrayList == null ? 0 : arrayList.size();
    }

    public void initData(ArrayList<AnimalButtonBean> Animallist) {
        if (arrayList != null) {
            arrayList.clear();
        }
        arrayList.addAll(Animallist);
        Log.e("tag", "mlist==============" + arrayList);
        notifyDataSetChanged();
    }


    class AnimalButtonViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.animal_details_btn)
        TextView animalDetailsBtn;

        public AnimalButtonViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @OnClick(R.id.animal_details_btn)
        public void onViewClicked() {
            mListener.onClick(getAdapterPosition(), animalDetailsBtn);
        }
    }

    public interface MyClickListener {
        void onClick(int postion, View view);
    }
}

