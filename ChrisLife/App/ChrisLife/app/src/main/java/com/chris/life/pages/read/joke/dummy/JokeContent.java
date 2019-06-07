package com.chris.life.pages.read.joke.dummy;

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
public class JokeContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<JokeItem> ITEMS = new ArrayList<JokeItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, JokeItem> ITEM_MAP = new HashMap<String, JokeItem>();

    private static final int COUNT = 25;


    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("笑话内容: ").append(position);
//        for (int i = 0; i < position; i++) {
//            builder.append("\nMore title information here.");
//        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of title.
     */
    public static class JokeItem {
        public final String hashId;
        public final String content;
        public final long unixtime;
        public final String updatetime;

        public JokeItem(String hashId, String content, long unixtime, String updatetime) {
            this.hashId = hashId;
            this.content = content;
            this.unixtime = unixtime;
            this.updatetime = updatetime;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
