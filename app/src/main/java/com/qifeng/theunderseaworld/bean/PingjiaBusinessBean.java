package com.qifeng.theunderseaworld.bean;

import java.io.Serializable;

/**
 * Created by liu on 2017/3/21.
 */

public class PingjiaBusinessBean implements Serializable {
    private int id;
    private int avatar;
    private String iamge_avatar;
    private String nick;
    private String time;
    private int score;
    private String pingjia;

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "PingjiaBusinessBean{" +
                "id=" + id +
                ", avatar=" + avatar +
                ", iamge_avatar='" + iamge_avatar + '\'' +
                ", nick='" + nick + '\'' +
                ", time='" + time + '\'' +
                ", score=" + score +
                ", pingjia='" + pingjia + '\'' +
                '}';
    }
}
