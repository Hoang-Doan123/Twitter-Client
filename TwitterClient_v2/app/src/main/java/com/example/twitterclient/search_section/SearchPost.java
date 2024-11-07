package com.example.twitterclient.search_section;

public class SearchPost {
    private String subtitle1, title, subtitle2;

    public String getSubtitle1() {
        return subtitle1;
    }

    public void setSubtitle1(String subtitle1) {
        this.subtitle1 = subtitle1;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle2() {
        return subtitle2;
    }

    public void setSubtitle2(String subtitle2) {
        this.subtitle2 = subtitle2;
    }

    public SearchPost(String subtitle1, String title, String subtitle2) {
        this.subtitle1 = subtitle1;
        this.title = title;
        this.subtitle2 = subtitle2;
    }
}
