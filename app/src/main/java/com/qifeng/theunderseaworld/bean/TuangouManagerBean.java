package com.qifeng.theunderseaworld.bean;

import java.io.Serializable;

/**
 * Created by liu on 2017/3/23.
 */

public class TuangouManagerBean implements Serializable {
    private int id;
    private int image;
    private String imageurl;
    private String title;
    private String sign;
    private String kuncun;
    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

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

    public String getKuncun() {
        return kuncun;
    }

    public void setKuncun(String kuncun) {
        this.kuncun = kuncun;
    }

    @Override
    public String toString() {
        return "TuangouManagerBean{" +
                "id=" + id +
                ", image=" + image +
                ", imageurl='" + imageurl + '\'' +
                ", title='" + title + '\'' +
                ", sign='" + sign + '\'' +
                ", kuncun='" + kuncun + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
