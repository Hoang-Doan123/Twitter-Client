package com.example.twitterclient.home_section;

public class Post {
    private int userAvatar, postImg;
    private String userName, postTitle, commentAmount, likeAmount;

    public int getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(int userAvatar) {
        this.userAvatar = userAvatar;
    }

    public int getPostImg() {
        return postImg;
    }

    public void setPostImg(int postImg) {
        this.postImg = postImg;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getCommentAmount() {
        return commentAmount;
    }

    public void setCommentAmount(String commentAmount) {
        this.commentAmount = commentAmount;
    }

    public String getLikeAmount() {
        return likeAmount;
    }

    public void setLikeAmount(String likeAmount) {
        this.likeAmount = likeAmount;
    }

    public Post(int userAvatar, int postImg, String userName, String postTitle, String commentAmount, String likeAmount) {
        this.userAvatar = userAvatar;
        this.postImg = postImg;
        this.userName = userName;
        this.postTitle = postTitle;
        this.commentAmount = commentAmount;
        this.likeAmount = likeAmount;
    }
}
