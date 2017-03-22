package com.qifeng.theunderseaworld.bean;

import java.io.Serializable;

/**
 * Created by liu on 2017/3/22.
 */

public class OrderFinishedChildBean implements Serializable {
    private int childId;
    private int image;
    private String imageurl;
    private String title;
    private String sign;
    private String price;
    private String child_order_num;

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getChild_order_num() {
        return child_order_num;
    }

    public void setChild_order_num(String child_order_num) {
        this.child_order_num = child_order_num;
    }

    @Override
    public String toString() {
        return "OrderFinishedChildBean{" +
                "childId=" + childId +
                ", image=" + image +
                ", imageurl='" + imageurl + '\'' +
                ", title='" + title + '\'' +
                ", sign='" + sign + '\'' +
                ", price='" + price + '\'' +
                ", child_order_num=" + child_order_num +
                '}';
    }
}
