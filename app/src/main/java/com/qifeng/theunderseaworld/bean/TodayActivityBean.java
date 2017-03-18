package com.qifeng.theunderseaworld.bean;

import java.io.Serializable;

/**
 * Created by liu on 2017/3/18.
 */

public class TodayActivityBean implements Serializable{
    private int id;
    private String title;
    private String sign;
    private int price;
    private String imageurl;
    private String datatime;
    private int image;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDatatime() {
        return datatime;
    }

    public void setDatatime(String datatime) {
        this.datatime = datatime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    @Override
    public String toString() {
        return "TodayActivityBean{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", sign='" + sign + '\'' +
                ", price=" + price +
                ", imageurl='" + imageurl + '\'' +
                ", datatime='" + datatime + '\'' +
                '}';
    }
}
