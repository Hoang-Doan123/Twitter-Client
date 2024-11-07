package com.example.twitterclient.email_section;

public class EmailPost {
    private int emailUserAvatar;
    private String emailUserName, emailUserTag, emailPostDate, emailPostContent;

    public EmailPost(int emailUserAvatar, String emailUserName, String emailUserTag, String emailPostDate, String emailPostContent) {
        this.emailUserAvatar = emailUserAvatar;
        this.emailUserName = emailUserName;
        this.emailUserTag = emailUserTag;
        this.emailPostDate = emailPostDate;
        this.emailPostContent = emailPostContent;
    }

    public int getEmailUserAvatar() {
        return emailUserAvatar;
    }

    public void setEmailUserAvatar(int emailUserAvatar) {
        this.emailUserAvatar = emailUserAvatar;
    }

    public String getEmailUserName() {
        return emailUserName;
    }

    public void setEmailUserName(String emailUserName) {
        this.emailUserName = emailUserName;
    }

    public String getEmailUserTag() {
        return emailUserTag;
    }

    public void setEmailUserTag(String emailUserTag) {
        this.emailUserTag = emailUserTag;
    }

    public String getEmailPostDate() {
        return emailPostDate;
    }

    public void setEmailPostDate(String emailPostDate) {
        this.emailPostDate = emailPostDate;
    }

    public String getEmailPostContent() {
        return emailPostContent;
    }

    public void setEmailPostContent(String emailPostContent) {
        this.emailPostContent = emailPostContent;
    }
}
