package com.example.twitterclient.home_section;

public class CardFollow {
    private int cardFollowAvatar;
    private String cardFollowName, CardFollowTag;

    public CardFollow(int cardFollowAvatar, String cardFollowName, String CardFollowTag) {
        this.cardFollowAvatar = cardFollowAvatar;
        this.cardFollowName = cardFollowName;
        this.CardFollowTag = CardFollowTag;
    }

    public int getCardFollowAvatar() {
        return cardFollowAvatar;
    }

    public void setCardFollowAvatar(int cardFollowAvatar) {
        this.cardFollowAvatar = cardFollowAvatar;
    }

    public String getCardFollowName() {
        return cardFollowName;
    }

    public void setCardFollowName(String cardFollowName) {
        this.cardFollowName = cardFollowName;
    }

    public String getCardFollowTag() {
        return CardFollowTag;
    }

    public void setCardFollowTag(String CardFollowTag) {
        this.CardFollowTag = CardFollowTag;
    }
}
