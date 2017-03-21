package com.qifeng.theunderseaworld.bean;

import java.io.Serializable;

/**
 * Created by liu on 2017/3/21.
 */

public class OrderManagementBean implements Serializable {
    private int image;
    private int imageurl;
    private String title;
    private String sign;
    private long ordernum;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImageurl() {
        return imageurl;
    }

    public void setImageurl(int imageurl) {
        this.imageurl = imageurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public long getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(long ordernum) {
        this.ordernum = ordernum;
    }

    @Override
    public String toString() {
        return "OrderManagementBean{" +
                "image=" + image +
                ", imageurl=" + imageurl +
                ", title='" + title + '\'' +
                ", sign='" + sign + '\'' +
                ", ordernum=" + ordernum +
                '}';
    }
}
