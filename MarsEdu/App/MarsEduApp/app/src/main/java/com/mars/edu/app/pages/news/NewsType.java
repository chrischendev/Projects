package com.mars.edu.app.pages.news;

/**
 * @author Chris Chan
 * on 2019/7/10 9:37
 * use for:
 */
public class NewsType {
    public String type;
    public String typeName;

    public NewsType() {
    }

    public NewsType(String type, String typeName) {
        this.type = type;
        this.typeName = typeName;
    }

    public static NewsType create(String type, String typeName) {
        return new NewsType(type, typeName);
    }
}
