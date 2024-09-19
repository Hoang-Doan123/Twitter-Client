package com.example.tablayout;

public class Explore {

    public static final int TYPE_food = 1;
    public static final int TYPE_animal = 2;
    public static final int TYPE_tech = 3;
    public static final int TYPE_art = 4;
    public static final int TYPE_sports= 5;
    public static final int TYPE_gaming = 6;



    private  int image;
    private int type;

    public Explore(int image, int type) {
        this.image = image;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
