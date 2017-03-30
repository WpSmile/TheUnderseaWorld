package com.qifeng.theunderseaworld.bean;

import java.io.Serializable;

public class CartTuijianBean implements Serializable {

    private String goodsId;
    private String goodsTitle;
    private String goodsPrice;
    private String goodsActivityprice;
    private String goodsNum;
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
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }
    public String getGoodsId() {
        return goodsId;
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

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }
    public String getGoodsNum() {
        return goodsNum;
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

    @Override
    public String toString() {
        return "{" +
                "goodsId='" + goodsId + '\'' +
                ", goodsTitle='" + goodsTitle + '\'' +
                ", goodsPrice='" + goodsPrice + '\'' +
                ", goodsActivityprice='" + goodsActivityprice + '\'' +
                ", goodsNum='" + goodsNum + '\'' +
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
