package com.qifeng.theunderseaworld.bean;

import java.io.Serializable;

/**
 * Created by liu on 2017/3/18.
 */

public class HomeKePuAnimalBean implements Serializable {
    private String scienceId;
    private String scienceTitle;
    private String scienceEnglishTitle;

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


    public void setScienceEnglishTitle(String scienceEnglishTitle) {
        this.scienceEnglishTitle = scienceEnglishTitle;
    }

    public String getScienceEnglishTitle() {
        return scienceEnglishTitle;
    }

    @Override
    public String toString() {
        return "HomeKePuAnimalBean{" +
                "scienceId='" + scienceId + '\'' +
                ", scienceTitle='" + scienceTitle + '\'' +
                ", scienceEnglishTitle='" + scienceEnglishTitle + '\'' +
                '}';
    }
}
