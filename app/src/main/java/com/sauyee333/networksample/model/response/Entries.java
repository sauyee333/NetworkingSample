package com.sauyee333.networksample.model.response;

/**
 * Created by sauyee on 20/9/16.
 */
public class Entries {
    private String content;

    private String author;

    private String title;

    private String link;

    private String contentSnippet;

    private String[] categories;

    private String publishedDate;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getContentSnippet() {
        return contentSnippet;
    }

    public void setContentSnippet(String contentSnippet) {
        this.contentSnippet = contentSnippet;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Override
    public String toString() {
        return "ClassPojo [content = " + content + ", author = " + author + ", title = " + title + ", link = " + link + ", contentSnippet = " + contentSnippet + ", categories = " + categories + ", publishedDate = " + publishedDate + "]";
    }
}
