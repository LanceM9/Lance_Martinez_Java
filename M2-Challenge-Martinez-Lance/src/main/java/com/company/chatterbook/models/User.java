package com.company.chatterbook.models;

import com.company.chatterbook.ChatterbookApplication;

import java.util.List;

public class User {
    private String name;
    private List<ChatterPost> chatterPosts;

    // User constructor
    public User (String aname) {
        this.name = aname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ChatterPost> getChatterPosts() {
        return chatterPosts;
    }

    public void setChatterPosts(List<ChatterPost> chatterPosts) {
        this.chatterPosts = chatterPosts;
    }
}
