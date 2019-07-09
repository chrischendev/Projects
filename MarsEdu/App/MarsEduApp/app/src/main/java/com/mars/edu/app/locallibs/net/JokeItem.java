package com.mars.edu.app.locallibs.net;

/**
 * create by Chris Chan
 * create on 2019/7/9 23:53
 * use for :
 */
public class JokeItem {
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
}
