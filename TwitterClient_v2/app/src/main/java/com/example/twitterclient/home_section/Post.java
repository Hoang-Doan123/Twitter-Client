package com.example.twitterclient.home_section;

import com.example.twitterclient.R;

import java.util.Random;

public class Post {
    private static class RandomGenerator {
        private final int arr[];
        private final Random random = new Random();

        RandomGenerator(int[] arr) {
            this.arr = arr;
        }

        public int getRandomValue() {
            int randomIndex = random.nextInt(arr.length);

            return arr[randomIndex];
        }
    }

    private int avatarResources[] = {
            R.drawable.dragon,
            R.drawable.dark,
            R.drawable.electric,
            R.drawable.ghost,
            R.drawable.flying
    };

    private int imageResources[] = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7
    };

    private int userAvatar, postImg;
    private String userName, postDate, postTitle;
    private int commentAmount, repostAmount, likeAmount;

    private final RandomGenerator avatarGenerator = new RandomGenerator(avatarResources);
    private final RandomGenerator imageGenerator = new RandomGenerator(imageResources);

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPostDate() { return postDate; }

    public void setPostDate(String postDate) { this.postDate = postDate; }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public int getCommentAmount() {
        return commentAmount;
    }

    public void setCommentAmount(int commentAmount) {
        this.commentAmount = commentAmount;
    }

    public int getRepostAmount() { return repostAmount; }

    public void setRepostAmount(int repostAmount) { this.repostAmount = repostAmount; }

    public int getLikeAmount() {
        return likeAmount;
    }

    public void setLikeAmount(int likeAmount) {
        this.likeAmount = likeAmount;
    }

    public int getPostImg() { return postImg; }

    public int getUserAvatar() { return userAvatar; }

    public Post(
            String userName,
            String postDate,
            String postTitle,
            int commentAmount,
            int repostAmount,
            int likeAmount) {
        this.userAvatar = avatarGenerator.getRandomValue();
        this.postImg = imageGenerator.getRandomValue();
        this.userName = userName;
        this.postDate = postDate;
        this.postTitle = postTitle;
        this.commentAmount = commentAmount;
        this.repostAmount = repostAmount;
        this.likeAmount = likeAmount;
    }
}
