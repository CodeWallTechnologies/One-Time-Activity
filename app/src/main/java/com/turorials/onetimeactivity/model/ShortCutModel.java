package com.turorials.onetimeactivity.model;

import java.util.ArrayList;
import java.util.List;

public class ShortCutModel {
    String title;
    String image_url;
    List<ChildImagesModel> childImagesModelList;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public List<ChildImagesModel> getChildImagesModelList() {
        return childImagesModelList;
    }

    public void setChildImagesModelList(List<ChildImagesModel> childImagesModelList) {
        this.childImagesModelList = childImagesModelList;
    }
}
