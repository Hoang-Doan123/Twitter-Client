package com.example.twitterclient.email_section;

public class EmailDirectMessagesPost {
    private int emailDirectMessUserAvatar;
    private String emailDirectMessUserName, emailDirectMessPostContent;

    public EmailDirectMessagesPost(int emailDirectMessUserAvatar, String emailDirectMessUserName, String emailDirectMessPostContent) {
        this.emailDirectMessUserAvatar = emailDirectMessUserAvatar;
        this.emailDirectMessUserName = emailDirectMessUserName;
        this.emailDirectMessPostContent = emailDirectMessPostContent;
    }

    public int getEmailDirectMessUserAvatar() {
        return emailDirectMessUserAvatar;
    }

    public void setEmailDirectMessUserAvatar(int emailDirectMessUserAvatar) {
        this.emailDirectMessUserAvatar = emailDirectMessUserAvatar;
    }

    public String getEmailDirectMessUserName() {
        return emailDirectMessUserName;
    }

    public void setEmailDirectMessUserName(String emailDirectMessUserName) {
        this.emailDirectMessUserName = emailDirectMessUserName;
    }

    public String getEmailDirectMessPostContent() {
        return emailDirectMessPostContent;
    }

    public void setEmailDirectMessPostContent(String emailDirectMessPostContent) {
        this.emailDirectMessPostContent = emailDirectMessPostContent;
    }
}
