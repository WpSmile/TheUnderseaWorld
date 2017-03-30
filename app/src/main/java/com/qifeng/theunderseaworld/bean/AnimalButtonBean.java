package com.qifeng.theunderseaworld.bean;

import java.io.Serializable;

/**
 * Created by liu on 2017/3/29.
 */

public class AnimalButtonBean implements Serializable {
    private String btn_id;
    private String btn_title;

    public String getBtn_title() {
        return btn_title;
    }

    public void setBtn_title(String btn_title) {
        this.btn_title = btn_title;
    }

    public String getBtn_id() {
        return btn_id;
    }

    public void setBtn_id(String btn_id) {
        this.btn_id = btn_id;
    }


    @Override
    public String toString() {
        return "{" +
                "btn_id='" + btn_id + '\'' +
                ", btn_title='" + btn_title + '\'' +
                '}';
    }
}
