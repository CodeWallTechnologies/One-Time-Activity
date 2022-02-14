package com.turorials.onetimeactivity.model;

public class WebsiteModel {
    int website_logo;
    String website_title;
    int website_main_image;
    String website_link;

    public WebsiteModel(int website_logo, String website_title, int website_main_image, String website_link) {
        this.website_logo = website_logo;
        this.website_title = website_title;
        this.website_main_image = website_main_image;
        this.website_link = website_link;
    }

    public int getWebsite_logo() {
        return website_logo;
    }

    public String getWebsite_title() {
        return website_title;
    }

    public int getWebsite_main_image() {
        return website_main_image;
    }

    public String getWebsite_link() {
        return website_link;
    }
}
