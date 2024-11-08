package com.example.twitterclient.community_section;

public class ExplorePost {
    private int explorePostUserAvatar, explorePostImg;
    private String communityName, explorePostUserName, explorePostTag, explorePostStatus, commentAmount, likeAmount;

    public int getExplorePostUserAvatar() {
        return explorePostUserAvatar;
    }

    public void setExplorePostUserAvatar(int explorePostUserAvatar) {
        this.explorePostUserAvatar = explorePostUserAvatar;
    }

    public int getExplorePostImg() {
        return explorePostImg;
    }

    public void setExplorePostImg(int explorePostImg) {
        this.explorePostImg = explorePostImg;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getExplorePostUserName() {
        return explorePostUserName;
    }

    public void setExplorePostUserName(String explorePostUserName) {
        this.explorePostUserName = explorePostUserName;
    }

    public String getExplorePostTag() {
        return explorePostTag;
    }

    public void setExplorePostTag(String explorePostTag) {
        this.explorePostTag = explorePostTag;
    }

    public String getExplorePostStatus() {
        return explorePostStatus;
    }

    public void setExplorePostStatus(String explorePostStatus) {
        this.explorePostStatus = explorePostStatus;
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

    public ExplorePost(int explorePostUserAvatar, int explorePostImg, String communityName, String explorePostUserName, String explorePostTag, String explorePostStatus, String commentAmount, String likeAmount) {
        this.explorePostUserAvatar = explorePostUserAvatar;
        this.explorePostImg = explorePostImg;
        this.communityName = communityName;
        this.explorePostUserName = explorePostUserName;
        this.explorePostTag = explorePostTag;
        this.explorePostStatus = explorePostStatus;
        this.commentAmount = commentAmount;
        this.likeAmount = likeAmount;
    }
}
