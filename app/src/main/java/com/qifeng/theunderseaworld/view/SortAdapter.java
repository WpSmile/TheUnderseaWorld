package com.qifeng.theunderseaworld.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;


import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.seabed_state.SeabedViewHolder;

import java.util.List;

public class SortAdapter extends BaseAdapter implements SectionIndexer {

    private List<SortModel> list = null;

    private Context mContext;

    public SortAdapter(Context mContext, List<SortModel> list) {
        this.mContext = mContext;
        this.list = list;
    }


    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SeabedViewHolder seabedViewHolder = null;
        final SortModel mContent = list.get(position);
        if (convertView == null) {
            seabedViewHolder = new SeabedViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item, null);
            seabedViewHolder.tvSeabedCountryItemTitle = (TextView) convertView.findViewById(R.id.tv_seabed_country_item_title);
            seabedViewHolder.tvSeabedCountryItemCatalog = (TextView) convertView.findViewById(R.id.tv_seabed_country_item_catalog);
            seabedViewHolder.tvSeabedCountryItemLine = (TextView) convertView.findViewById(R.id.tv_seabed_country_item_line);
            convertView.setTag(seabedViewHolder);
        } else {
            seabedViewHolder = (SeabedViewHolder) convertView.getTag();
        }
        int section = getSectionForPosition(position);
        if (position == getPositionForSection(section)) {
            seabedViewHolder.tvSeabedCountryItemCatalog.setVisibility(View.VISIBLE);
            seabedViewHolder.tvSeabedCountryItemCatalog.setText(mContent.getSortLetters());
        } else {
            seabedViewHolder.tvSeabedCountryItemCatalog.setVisibility(View.GONE);
        }
        seabedViewHolder.tvSeabedCountryItemTitle.setText(this.list.get(position).getName());
        return convertView;
    }

    @Override
    public Object[] getSections() {
        return null;
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        for (int i = 0; i < getCount(); i++) {
            String sortStr = list.get(i).getSortLetters();
            char firstChar = sortStr.toUpperCase().charAt(0);
            if (firstChar == sectionIndex) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int getSectionForPosition(int position) {
        return list.get(position).getSortLetters().charAt(0);
    }


    final static class ViewHolder {
        TextView tvLetter;
        TextView tvTitle;
        TextView tvLine;
    }
}
