package com.turorials.onetimeactivity.model;

public class ShortCutModel {
    String title;
    int imgResource;


    public ShortCutModel(String title, int imgResource) {
        this.title = title;
        this.imgResource = imgResource;
    }


    public String getTitle() {
        return title;
    }

    public int getImgResource() {
        return imgResource;
    }
}
