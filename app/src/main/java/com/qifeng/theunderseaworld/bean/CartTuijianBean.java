package com.qifeng.theunderseaworld.bean;

import java.io.Serializable;

public class CartTuijianBean implements Serializable {

    private int id=0;
    private String title;
    private String imageurl;
    private int image;
    private int price;
    private String ticketStyle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTicketStyle() {
        return ticketStyle;
    }

    public void setTicketStyle(String ticketStyle) {
        this.ticketStyle = ticketStyle;
    }

    @Override
    public String toString() {
        return "CartTuijianBean{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imageurl='" + imageurl + '\'' +
                ", image=" + image +
                ", price=" + price +
                ", ticketStyle='" + ticketStyle + '\'' +
                '}';
    }
}
