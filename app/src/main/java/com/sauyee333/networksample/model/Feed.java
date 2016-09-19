package com.sauyee333.networksample.model;

/**
 * Created by sauyee on 20/9/16.
 */
public class Feed {
    private String author;

    private String title;

    private String feedUrl;

    private String description;

    private String link;

    private Entries[] entries;

    private String type;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFeedUrl() {
        return feedUrl;
    }

    public void setFeedUrl(String feedUrl) {
        this.feedUrl = feedUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Entries[] getEntries() {
        return entries;
    }

    public void setEntries(Entries[] entries) {
        this.entries = entries;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ClassPojo [author = " + author + ", title = " + title + ", feedUrl = " + feedUrl + ", description = " + description + ", link = " + link + ", entries = " + entries + ", type = " + type + "]";
    }
}
