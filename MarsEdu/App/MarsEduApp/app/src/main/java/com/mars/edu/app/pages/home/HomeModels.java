package com.mars.edu.app.pages.home;

import android.graphics.Color;

/**
 * @author Chris Chan
 * on 2019/7/9 15:10
 * use for:
 */
public class HomeModels {
    static class NavItem {
        public String title;
        public Color bgColor;
        public int bgColorId;
        public String bgColorStr;

        public NavItem() {
        }

        public NavItem(String title, int bgColorId) {
            this.title = title;
            this.bgColorId = bgColorId;
        }
    }
}
