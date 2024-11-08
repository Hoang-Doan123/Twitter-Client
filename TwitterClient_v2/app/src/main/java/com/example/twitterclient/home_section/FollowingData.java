package com.example.twitterclient.home_section;

import java.util.List;

public class FollowingData {
    private int type;
    private List<CardFollow> listCardFollow;
    private List<com.example.twitterclient.home_section.Post> listPost;

    public FollowingData(int type, List<CardFollow> listCardFollow, List<com.example.twitterclient.home_section.Post> listPost) {
        this.type = type;
        this.listCardFollow = listCardFollow;
        this.listPost = listPost;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<CardFollow> getListCardFollow() {
        return listCardFollow;
    }

    public void setListCardFollow(List<CardFollow> listCardFollow) {
        this.listCardFollow = listCardFollow;
    }

    public List<com.example.twitterclient.home_section.Post> getListPost() {
        return listPost;
    }

    public void setListPost(List<Post> listPost) {
        this.listPost = listPost;
    }
}
