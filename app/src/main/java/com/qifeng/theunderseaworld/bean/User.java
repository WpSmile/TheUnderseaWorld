package com.qifeng.theunderseaworld.bean;



import java.io.Serializable;



/**
 * Created by Administrator on 2016/10/21.
 */
public class User implements Serializable{


        private String userId;
        private String username;
        private String email;
        private String mobile;
        private String realName;
        private String nickname;
        private String qq;
        private String lastIp;
        private String lastTime;
        private String loginNum;
        private String levelId;
        private String images;
        private String activation;
        private String birthday;
        private String atTime;
        private String disable;
        private String headPortrait;
        private String isGag;
        public void setUserId(String userId) {
            this.userId = userId;
        }
        public String getUserId() {
            return userId;
        }

        public void setUsername(String username) {
            this.username = username;
        }
        public String getUsername() {
            return username;
        }

        public void setEmail(String email) {
            this.email = email;
        }
        public String getEmail() {
            return email;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }
        public String getMobile() {
            return mobile;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }
        public String getRealName() {
            return realName;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }
        public String getNickname() {
            return nickname;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }
        public String getQq() {
            return qq;
        }

        public void setLastIp(String lastIp) {
            this.lastIp = lastIp;
        }
        public String getLastIp() {
            return lastIp;
        }

        public void setLastTime(String lastTime) {
            this.lastTime = lastTime;
        }
        public String getLastTime() {
            return lastTime;
        }

        public void setLoginNum(String loginNum) {
            this.loginNum = loginNum;
        }
        public String getLoginNum() {
            return loginNum;
        }

        public void setLevelId(String levelId) {
            this.levelId = levelId;
        }
        public String getLevelId() {
            return levelId;
        }

        public void setImages(String images) {
            this.images = images;
        }
        public String getImages() {
            return images;
        }

        public void setActivation(String activation) {
            this.activation = activation;
        }
        public String getActivation() {
            return activation;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }
        public String getBirthday() {
            return birthday;
        }

        public void setAtTime(String atTime) {
            this.atTime = atTime;
        }
        public String getAtTime() {
            return atTime;
        }

        public void setDisable(String disable) {
            this.disable = disable;
        }
        public String getDisable() {
            return disable;
        }

        public void setHeadPortrait(String headPortrait) {
            this.headPortrait = headPortrait;
        }
        public String getHeadPortrait() {
            return headPortrait;
        }

        public void setIsGag(String isGag) {
            this.isGag = isGag;
        }
        public String getIsGag() {
            return isGag;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!username.equals(user.username)) return false;
        return lastTime.equals(user.lastTime);

    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + lastTime.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", realName='" + realName + '\'' +
                ", nickname='" + nickname + '\'' +
                ", qq='" + qq + '\'' +
                ", lastIp='" + lastIp + '\'' +
                ", lastTime='" + lastTime + '\'' +
                ", loginNum='" + loginNum + '\'' +
                ", levelId='" + levelId + '\'' +
                ", images='" + images + '\'' +
                ", activation='" + activation + '\'' +
                ", birthday='" + birthday + '\'' +
                ", atTime='" + atTime + '\'' +
                ", disable='" + disable + '\'' +
                ", headPortrait='" + headPortrait + '\'' +
                ", isGag='" + isGag + '\'' +
                '}';
    }
}
