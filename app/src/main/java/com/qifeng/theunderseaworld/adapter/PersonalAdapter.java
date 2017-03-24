package com.qifeng.theunderseaworld.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.seabed_state.SeabedState;
import com.qifeng.theunderseaworld.seabed_state.SeabedViewHolder;
import com.qifeng.theunderseaworld.view.CircleImageView;

/**
 * 个人信息集合
 * Created by XinAiXiaoWen on 2017/3/20.
 */

public class PersonalAdapter extends BaseAdapter {

    private Context personalContext = null;

    private SeabedState seabedState = SeabedState.getSeabedState();

    public PersonalAdapter(Context personalContext) {
        this.personalContext = personalContext;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0) {
            return 0;
        } else if(position == getCount()-1){
            return 2;
        } else {
            return 1;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getCount() {
        return seabedState.getPersonalList().size()+1;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SeabedViewHolder seabedViewHolder = null;
        int type = getItemViewType(position);
        if(type == 0){
            convertView = LayoutInflater.from(personalContext).inflate(R.layout.personal_head,null);
            seabedViewHolder = new SeabedViewHolder();
            seabedViewHolder.ciSeabedPersonalItemHead = (CircleImageView) convertView.findViewById(R.id.ci_seabed_personal_item_head);
        } else if(type == 1){
            convertView = LayoutInflater.from(personalContext).inflate(R.layout.personal_content,null);
            seabedViewHolder = new SeabedViewHolder();
            seabedViewHolder.tvSeabedPersonalItemContext = (TextView) convertView.findViewById(R.id.tv_seabed_personal_item_context);
            seabedViewHolder.tvSeabedPersonalItemType = (TextView) convertView.findViewById(R.id.tv_seabed_personal_item_type);
            seabedViewHolder.tvSeabedPersonalItemContext.setText(seabedState.getPersonalList().get(position-1).getPersonal());
            seabedViewHolder.tvSeabedPersonalItemType.setText(seabedState.getPersonalList().get(position-1).getPersonalType());
        } else {
            convertView = LayoutInflater.from(personalContext).inflate(R.layout.item_personal_footer,null);
            seabedViewHolder = new SeabedViewHolder();
            seabedViewHolder.tvSeabedPersonalItemContext = (TextView) convertView.findViewById(R.id.tv_seabed_personal_item_context);
            seabedViewHolder.tvSeabedPersonalItemType = (TextView) convertView.findViewById(R.id.tv_seabed_personal_item_type);
            seabedViewHolder.tvSeabedPersonalItemContext.setText(seabedState.getPersonalList().get(position-1).getPersonal());
            seabedViewHolder.tvSeabedPersonalItemType.setText(seabedState.getPersonalList().get(position-1).getPersonalType());
        }

        return convertView;
    }
}
