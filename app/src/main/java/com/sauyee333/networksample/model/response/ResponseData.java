package com.sauyee333.networksample.model.response;

/**
 * Created by sauyee on 20/9/16.
 */
public class ResponseData {
    private Feed feed;

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    @Override
    public String toString() {
        return "ClassPojo [feed = " + feed + "]";
    }
}
