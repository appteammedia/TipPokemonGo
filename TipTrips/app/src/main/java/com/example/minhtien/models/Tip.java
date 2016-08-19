package com.example.minhtien.models;

/**
 * Created by minhtien on 8/18/2016.
 */
public class Tip {
    private int index;
    private String title;
    private String details;

    public Tip(String title) {
        this.title = title;
    }

    public Tip(String title, String details) {
        this.title = title;
        this.details = details;
    }

    public Tip(int index, String title) {
        this.index = index;
        this.title = title;
    }

    public int getIndex() {
        return index;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }
}
