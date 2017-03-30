package com.qifeng.theunderseaworld.bean;

import java.io.Serializable;

public class CartBean implements Serializable {

    private String id;
    private String goodsId;
    private String goodsNum;
    private String uid;
    private String goodsTitle;
    private String goodsPrice;
    private String goodsActivityprice;
    private String goodsDetails;
    private String state;
    private String activityId;
    private String releaseTime;
    private String totalSales;
    private String image;
    private String thumbImage;
    private String categoryId;
    private String stateIntro;
    private String categoryName;

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }
    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }
    public String getGoodsNum() {
        return goodsNum;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
    public String getUid() {
        return uid;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }
    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsActivityprice(String goodsActivityprice) {
        this.goodsActivityprice = goodsActivityprice;
    }
    public String getGoodsActivityprice() {
        return goodsActivityprice;
    }

    public void setGoodsDetails(String goodsDetails) {
        this.goodsDetails = goodsDetails;
    }
    public String getGoodsDetails() {
        return goodsDetails;
    }

    public void setState(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }
    public String getActivityId() {
        return activityId;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }
    public String getReleaseTime() {
        return releaseTime;
    }

    public void setTotalSales(String totalSales) {
        this.totalSales = totalSales;
    }
    public String getTotalSales() {
        return totalSales;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public String getImage() {
        return image;
    }

    public void setThumbImage(String thumbImage) {
        this.thumbImage = thumbImage;
    }
    public String getThumbImage() {
        return thumbImage;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
    public String getCategoryId() {
        return categoryId;
    }

    public void setStateIntro(String stateIntro) {
        this.stateIntro = stateIntro;
    }
    public String getStateIntro() {
        return stateIntro;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public String getCategoryName() {
        return categoryName;
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
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", goodsNum='" + goodsNum + '\'' +
                ", uid='" + uid + '\'' +
                ", goodsTitle='" + goodsTitle + '\'' +
                ", goodsPrice='" + goodsPrice + '\'' +
                ", goodsActivityprice='" + goodsActivityprice + '\'' +
                ", goodsDetails='" + goodsDetails + '\'' +
                ", state='" + state + '\'' +
                ", activityId='" + activityId + '\'' +
                ", releaseTime='" + releaseTime + '\'' +
                ", totalSales='" + totalSales + '\'' +
                ", image='" + image + '\'' +
                ", thumbImage='" + thumbImage + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", stateIntro='" + stateIntro + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
