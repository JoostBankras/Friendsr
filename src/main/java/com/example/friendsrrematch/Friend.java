package com.example.friendsrrematch;

import java.io.Serializable;

public class Friend implements Serializable {

//    define variables for Friend
    private String name, bio;
    private float rating;
    private int DrawableId;

    public Friend(String name, String bio, int drawableId) {
        this.name = name;
        this.bio = bio;
        DrawableId = drawableId;
    }

//    all the getters and setters
    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public float getRating() {
        return rating;
    }

    public int getDrawableId() {
        return DrawableId;
    }

}
