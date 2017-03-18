package com.qifeng.theunderseaworld.bean;

import java.io.Serializable;

/**
 * Created by liu on 2017/3/18.
 */

public class HomeKePuAnimalBean implements Serializable {
    private int id;
    private String name;
    private String EnglishName;
    private int image;
    private String iamgeurl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnglishName() {
        return EnglishName;
    }

    public void setEnglishName(String englishName) {
        EnglishName = englishName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "HomeKePuAnimalBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", EnglishName='" + EnglishName + '\'' +
                ", image=" + image +
                ", iamgeurl='" + iamgeurl + '\'' +
                '}';
    }
}
