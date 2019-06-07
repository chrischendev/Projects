package com.chris.life.pages.read.video.dummy;

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
public class VideoContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<VideoItem> ITEMS = new ArrayList<VideoItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, VideoItem> ITEM_MAP = new HashMap<String, VideoItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(VideoItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static VideoItem createDummyItem(int position) {
        return new VideoItem(String.valueOf(position), "视频标题 " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("视频内容: ").append(position);
//        for (int i = 0; i < position; i++) {
//            builder.append("\nMore title information here.");
//        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of title.
     */
    public static class VideoItem {
        public final String id;
        public final String title;
        public final String content;

        public VideoItem(String id, String title, String content) {
            this.id = id;
            this.title = title;
            this.content = content;
        }

        @Override
        public String toString() {
            return title;
        }
    }
}
