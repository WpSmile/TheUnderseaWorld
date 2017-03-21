package com.qifeng.theunderseaworld.bean;

import java.io.Serializable;

/**
 * Created by liu on 2017/3/21.
 */

public class PingjiaCustomerBean implements Serializable {
    private int avatar;
    private String iamge_avatar;
    private String nick;
    private String time;
    private int score;
    private String pingjia;
    private String image;//评价的景区图片
    private int image1;

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public int getImage1() {
        return image1;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIamge_avatar() {
        return iamge_avatar;
    }

    public void setIamge_avatar(String iamge_avatar) {
        this.iamge_avatar = iamge_avatar;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPingjia() {
        return pingjia;
    }

    public void setPingjia(String pingjia) {
        this.pingjia = pingjia;
    }

    @Override
    public String toString() {
        return "PingjiaCustomerBean{" +
                "avatar=" + avatar +
                ", iamge_avatar='" + iamge_avatar + '\'' +
                ", nick='" + nick + '\'' +
                ", time='" + time + '\'' +
                ", score=" + score +
                ", pingjia='" + pingjia + '\'' +
                ", image='" + image + '\'' +
                ", image1=" + image1 +
                '}';
    }
}
