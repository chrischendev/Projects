package com.mars.edu.app.locallibs.net;

/**
 * create by Chris Chan
 * create on 2019/7/9 23:54
 * use for :
 */
public class NewsItem {
    public final String author_name;
    public final String category;
    public final String date;
    public final String thumbnail_pic_s;
    public final String thumbnail_pic_s02;
    public final String thumbnail_pic_s03;

    public final String title;
    public final String uniquekey;
    public final String url;

    public NewsItem(String author_name, String category, String date, String thumbnail_pic_s, String thumbnail_pic_s02, String thumbnail_pic_s03, String title, String uniquekey, String url) {
        this.author_name = author_name;
        this.category = category;
        this.date = date;
        this.thumbnail_pic_s = thumbnail_pic_s;
        this.thumbnail_pic_s02 = thumbnail_pic_s02;
        this.thumbnail_pic_s03 = thumbnail_pic_s03;
        this.title = title;
        this.uniquekey = uniquekey;
        this.url = url;
    }
}
