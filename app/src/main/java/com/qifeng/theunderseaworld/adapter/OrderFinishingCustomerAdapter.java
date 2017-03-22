package com.qifeng.theunderseaworld.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.bean.OrderFinishedChildBean;
import com.qifeng.theunderseaworld.bean.OrderFinishedGroupBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 订单管理（客户端）已完成的适配器
 */

public class OrderFinishingCustomerAdapter extends BaseExpandableListAdapter {


    Context mContext;
    ArrayList<OrderFinishedGroupBean> grouplist;
    ArrayList<OrderFinishedChildBean> childlist;

    public OrderFinishingCustomerAdapter(Context mContext, ArrayList<OrderFinishedGroupBean> grouplist, ArrayList<OrderFinishedChildBean> childlist) {
        this.mContext = mContext;
        this.grouplist = grouplist;
        this.childlist = childlist;
    }

    @Override
    public int getGroupCount() {
        return grouplist != null ? grouplist.size() : 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        /*return childlist != null && childlist.get(groupPosition) != null ?
                childlist.get(groupPosition).size() : 0;*/
        return 2;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return grouplist != null ? grouplist.get(groupPosition) : null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childlist != null && childlist.get(groupPosition) != null ?
                childlist.get(childPosition) : null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return grouplist.get(groupPosition).getGroupId();
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder holder = null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_order_customer_group, null);
            holder = new GroupViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (GroupViewHolder) convertView.getTag();
        }
        holder.itemOrderCustomerGroupNum.setText(grouplist.get(groupPosition).getGroup_order_num());


        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder holder = null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_order_customer_child, null);
            holder = new ChildViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ChildViewHolder) convertView.getTag();
        }
        if (childlist != null) {

        }


        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


    static class GroupViewHolder {
        @BindView(R.id.item_order_customer_group_num)
        TextView itemOrderCustomerGroupNum;

        GroupViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class ChildViewHolder {
        @BindView(R.id.order_activity_title)
        TextView orderActivityTitle;
        @BindView(R.id.today_activity_sign)
        TextView todayActivitySign;
        @BindView(R.id.today_text_price)
        TextView todayTextPrice;
        @BindView(R.id.order_manager_btn_deal)
        TextView orderManagerBtnDeal;
        @BindView(R.id.order_manager_divider_line)
        View orderManagerDividerLine;
        @BindView(R.id.today_text_data_time)
        TextView todayTextDataTime;
        @BindView(R.id.order_activity_iamge)
        ImageView orderActivityIamge;
        @BindView(R.id.order_manager_tv_apply_refund)
        TextView orderManagerTvApplyRefund;
        @BindView(R.id.order_manager_tv_apply_tuihuo)
        TextView orderManagerTvApplyTuihuo;
        @BindView(R.id.order_manager_ll_pingjia)
        LinearLayout orderManagerLlPingjia;
        @BindView(R.id.item_order_manager_rl)
        RelativeLayout itemOrderManagerRl;

        ChildViewHolder(View view) {
            ButterKnife.bind(this, view);

            orderManagerBtnDeal.setText("待付款");
        }
    }


}
