package com.example.rejsedagbogapp;

public class JournalClass {

    public String title;
    public String text;
    public String time; //Maybe this shouldn't be a String
    public String gpsLocations; //Maybe this shouldn't be a String
    public String webLinks; //Maybe this shouldn't be a String

    public JournalClass(String title, String text, String time, String gpsLocations, String webLinks) {
        this.title = title;
        this.text = text;
        this.time = time;
        this.gpsLocations = gpsLocations;
        this.webLinks = webLinks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getGpsLocations() {
        return gpsLocations;
    }

    public void setGpsLocations(String gpsLocations) {
        this.gpsLocations = gpsLocations;
    }

    public String getWebLinks() {
        return webLinks;
    }

    public void setWebLinks(String webLinks) {
        this.webLinks = webLinks;
    }

    @Override
    public String toString() {
        return title;
    }
}
