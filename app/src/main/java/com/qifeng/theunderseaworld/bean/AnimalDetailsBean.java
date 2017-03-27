package com.qifeng.theunderseaworld.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/27.
 */

public class AnimalDetailsBean implements Serializable{
    private String animalid;
    private String animalIntro;

    public String getAnimalid() {
        return animalid;
    }

    public void setAnimalid(String animalid) {
        this.animalid = animalid;
    }

    public String getAnimalIntro() {
        return animalIntro;
    }

    public void setAnimalIntro(String animalIntro) {
        this.animalIntro = animalIntro;
    }


}
