package com.company.chatterbook.models;

public class ChatterPost {
    private String text; // contains user's "post"

    public ChatterPost (String post) {
        this.text = post;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
