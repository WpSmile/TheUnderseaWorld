package com.qifeng.theunderseaworld.bean;

import java.io.Serializable;

/**
 * Created by liu on 2017/3/22.
 */

public class PersonalCustomerTuijianBean implements Serializable {
    private int image;
    private String imageUrl;
    private String title;
    private String sign;
    private String percent;
    private String price;
    private String goods_id;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setGoodsId(String goods_id) {
        this.goods_id = goods_id;
    }
    public String getGoodsId(){
        return goods_id;
    }
}
