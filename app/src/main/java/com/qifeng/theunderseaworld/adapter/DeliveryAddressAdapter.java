package com.qifeng.theunderseaworld.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;


import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.seabed_state.SeabedViewHolder;

/**
 * Created by XinAiXiaoWen on 2017/3/21.
 */

public class DeliveryAddressAdapter extends BaseAdapter {

    private Context deliverAddressContext = null;

    public DeliveryAddressAdapter(Context deliverAddressContext) {
        this.deliverAddressContext = deliverAddressContext;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == getCount()-1) {
            return 2;
        } else {
            return 1;
        }
    }

    @Override
    public int getCount() {
        return 4;
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
        int type = getItemViewType(position);
        SeabedViewHolder seabedViewHolder =null;
        if(type == 1){
            if(convertView == null) {
                convertView = LayoutInflater.from(deliverAddressContext).inflate(R.layout.item_address, null);
                seabedViewHolder = new SeabedViewHolder();
                seabedViewHolder.rbSeabedDeliveryaddressItemSelect = (RadioButton) convertView.findViewById(R.id.rb_seabed_deliveryaddress_item_select);
                seabedViewHolder.tvSeabedDeliveryaddressItemName = (TextView) convertView.findViewById(R.id.tv_seabed_deliveryaddress_item_name);
                seabedViewHolder.tvSeabedDeliveryaddressItemPhone = (TextView) convertView.findViewById(R.id.tv_seabed_deliveryaddress_item_phone);
                seabedViewHolder.tvSeabedDeliveryaddressItemAddress = (TextView) convertView.findViewById(R.id.tv_seabed_deliveryaddress_item_address);
                convertView.setTag(seabedViewHolder);
            } else {
                seabedViewHolder = (SeabedViewHolder) convertView.getTag();
            }
            if(position == 0){
                seabedViewHolder.rbSeabedDeliveryaddressItemSelect.setChecked(true);
            }
        } else {
            convertView = LayoutInflater.from(deliverAddressContext).inflate(R.layout.item_add, null);
        }
        return convertView;
    }
}
