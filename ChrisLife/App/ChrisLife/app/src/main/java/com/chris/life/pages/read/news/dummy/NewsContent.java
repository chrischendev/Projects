package com.chris.life.pages.read.news.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample title for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class NewsContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<NewsItem> ITEMS = new ArrayList<NewsItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, NewsItem> ITEM_MAP = new HashMap<String, NewsItem>();

    private static final int COUNT = 25;

//    static {
//        // Add some sample items.
//        for (int i = 1; i <= COUNT; i++) {
//            addItem(createDummyItem(i));
//        }
//    }

    private static void addItem(NewsItem item) {
        ITEMS.add(item);
        //ITEM_MAP.put(item.id, item);
    }

//    private static NewsItem createDummyItem(int position) {
//        return new NewsItem(String.valueOf(position), "新闻标题 " + position, makeDetails(position));
//    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("每日新闻内容: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore title information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of title.
     */
    public static class NewsItem {

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

        @Override
        public String toString() {
            return title;
        }
    }

    public static List<NewsItem> getITEMS() {
        return ITEMS;
    }


}
