package com.qifeng.theunderseaworld.bean;

import java.io.Serializable;

/**
 * 商品设置
 * Created by liu on 2017/3/23.
 */

public class GoodsSetBean implements Serializable {
    private int id;
    private int image;
    private String iamgeurl;
    private String title;
    private String storename;
    private String kucun;
    private String price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getIamgeurl() {
        return iamgeurl;
    }

    public void setIamgeurl(String iamgeurl) {
        this.iamgeurl = iamgeurl;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKucun() {
        return kucun;
    }

    public void setKucun(String kucun) {
        this.kucun = kucun;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "GoodsSetBean{" +
                "id=" + id +
                ", image=" + image +
                ", iamgeurl='" + iamgeurl + '\'' +
                ", title='" + title + '\'' +
                ", storename='" + storename + '\'' +
                ", kucun='" + kucun + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
