package com.qifeng.theunderseaworld.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/27.
 */

public class AnimalDetailsBean implements Serializable{

    private String scienceId;
    private String scienceTitle;
    private String scienceContent;
    private String scienceEnglishTitle;
    private String scienceImagesId;
    private String path;
    private String thumbPath;
    private String sId;
    public void setScienceId(String scienceId) {
        this.scienceId = scienceId;
    }
    public String getScienceId() {
        return scienceId;
    }

    public void setScienceTitle(String scienceTitle) {
        this.scienceTitle = scienceTitle;
    }
    public String getScienceTitle() {
        return scienceTitle;
    }

    public void setScienceContent(String scienceContent) {
        this.scienceContent = scienceContent;
    }
    public String getScienceContent() {
        return scienceContent;
    }

    public void setScienceEnglishTitle(String scienceEnglishTitle) {
        this.scienceEnglishTitle = scienceEnglishTitle;
    }
    public String getScienceEnglishTitle() {
        return scienceEnglishTitle;
    }

    public void setScienceImagesId(String scienceImagesId) {
        this.scienceImagesId = scienceImagesId;
    }
    public String getScienceImagesId() {
        return scienceImagesId;
    }

    public void setPath(String path) {
        this.path = path;
    }
    public String getPath() {
        return path;
    }

    public void setThumbPath(String thumbPath) {
        this.thumbPath = thumbPath;
    }
    public String getThumbPath() {
        return thumbPath;
    }

    public void setSId(String sId) {
        this.sId = sId;
    }
    public String getSId() {
        return sId;
    }

    @Override
    public String toString() {
        return "{" +
                "scienceId='" + scienceId + '\'' +
                ", scienceTitle='" + scienceTitle + '\'' +
                ", scienceContent='" + scienceContent + '\'' +
                ", scienceEnglishTitle='" + scienceEnglishTitle + '\'' +
                ", scienceImagesId='" + scienceImagesId + '\'' +
                ", path='" + path + '\'' +
                ", thumbPath='" + thumbPath + '\'' +
                ", sId='" + sId + '\'' +
                '}';
    }
}
