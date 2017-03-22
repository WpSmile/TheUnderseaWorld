package com.qifeng.theunderseaworld.bean;

import java.io.Serializable;

/**
 * Created by liu on 2017/3/22.
 */

public class OrderFinishedGroupBean implements Serializable {
    private int groupId;
    private String group_order_num;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroup_order_num() {
        return group_order_num;
    }

    public void setGroup_order_num(String group_order_num) {
        this.group_order_num = group_order_num;
    }

    @Override
    public String toString() {
        return "OrderFinishedGroupBean{" +
                "groupId=" + groupId +
                ", group_order_num=" + group_order_num +
                '}';
    }
}
