package com.qifeng.theunderseaworld.bean;

import java.io.Serializable;

public class CartBean implements Serializable {

    private int id=0;
    private String name;
    private int goodsId;
    private int count;
    private boolean isChecked;
    private String imageurl;
    private int image;
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CartBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", goodsId=" + goodsId +
                ", count=" + count +
                ", isChecked=" + isChecked +
                ", imageurl='" + imageurl + '\'' +
                ", image=" + image +
                ", price=" + price +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public CartBean() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartBean)) return false;

        CartBean cartBean = (CartBean) o;

        return getId() == cartBean.getId();

    }

    @Override
    public int hashCode() {
        return getId();
    }


}
