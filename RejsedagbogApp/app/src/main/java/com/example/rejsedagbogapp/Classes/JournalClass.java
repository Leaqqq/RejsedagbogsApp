package com.example.rejsedagbogapp.Classes;

public class JournalClass {

    public String title;
    public String text;
    public String time; //Maybe this shouldn't be a String
    public String longitude; //Maybe this shouldn't be a String
    public String latitude;
    public String webLinks; //Maybe this shouldn't be a String

    public JournalClass(String title, String text, String time, String longitude,String latitude, String webLinks) {
        this.title = title;
        this.text = text;
        this.time = time;
        this.longitude=longitude;
        this.latitude=latitude;
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

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
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
