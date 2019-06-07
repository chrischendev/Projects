package com.chris.life.pages.main;

public class MainItem {
    public String title;
    public String imgUrl;
    public int imgId;

    public MainItem() {
    }

    public MainItem(String title, String imgUrl) {
        this.title = title;
        this.imgUrl = imgUrl;
    }

    public MainItem(String title, int imgId) {
        this.title = title;
        this.imgId = imgId;
    }

    public MainItem(String title, String imgUrl, int imgId) {
        this.title = title;
        this.imgUrl = imgUrl;
        this.imgId = imgId;
    }

    public static MainItem create(String title, int imgId) {
        return new MainItem(title, imgId);
    }

    public static MainItem create(String title, String imgUrl) {
        return new MainItem(title, imgUrl);
    }

    public static MainItem create(String title, String imgUrl, int imgId) {
        return new MainItem(title, imgUrl, imgId);
    }
}
