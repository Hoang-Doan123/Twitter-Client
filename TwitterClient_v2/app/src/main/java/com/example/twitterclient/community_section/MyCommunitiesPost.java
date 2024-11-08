package com.example.twitterclient.community_section;

public class MyCommunitiesPost {
    private int communitiesPostAvatar;
    private String communitiesPostName, communitiesPostNumberMembers, communitiesPostTopic;

    public int getCommunitiesPostAvatar() {
        return communitiesPostAvatar;
    }

    public void setCommunitiesPostAvatar(int communitiesPostAvatar) {
        this.communitiesPostAvatar = communitiesPostAvatar;
    }

    public String getCommunitiesPostName() {
        return communitiesPostName;
    }

    public void setCommunitiesPostName(String communitiesPostName) {
        this.communitiesPostName = communitiesPostName;
    }

    public String getCommunitiesPostNumberMembers() {
        return communitiesPostNumberMembers;
    }

    public void setCommunitiesPostNumberMembers(String communitiesPostNumberMembers) {
        this.communitiesPostNumberMembers = communitiesPostNumberMembers;
    }

    public String getCommunitiesPostTopic() {
        return communitiesPostTopic;
    }

    public void setCommunitiesPostTopic(String communitiesPostTopic) {
        this.communitiesPostTopic = communitiesPostTopic;
    }

    public MyCommunitiesPost(int communitiesPostAvatar, String communitiesPostName, String communitiesPostNumberMembers, String communitiesPostTopic) {
        this.communitiesPostAvatar = communitiesPostAvatar;
        this.communitiesPostName = communitiesPostName;
        this.communitiesPostNumberMembers = communitiesPostNumberMembers;
        this.communitiesPostTopic = communitiesPostTopic;
    }
}
