package com.qifeng.theunderseaworld.view;

/**
 * Created by XinAiXiaoWen on 2017/3/21.
 */

public class Personal {

    private String personal;

    private String personalType;

    public Personal(String personal, String personalType) {
        this.personal = personal;
        this.personalType = personalType;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }

    public String getPersonalType() {
        return personalType;
    }

    public void setPersonalType(String personalType) {
        this.personalType = personalType;
    }
}
