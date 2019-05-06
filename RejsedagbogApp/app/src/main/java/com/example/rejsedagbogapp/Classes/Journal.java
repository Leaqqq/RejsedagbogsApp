package com.example.rejsedagbogapp.Classes;

public class Journal {

    private Long id;
    private String title;
    private String text;
    private String time; //Maybe this shouldn't be a String
    private String longitude; //Maybe this shouldn't be a String
    private String latitude;
    private String webLinks; //Maybe this shouldn't be a String
    private Travel travel;


    public Journal(String title, String text, String time, String longitude, String latitude, String webLinks) {
        this.title = title;
        this.text = text;
        this.time = time;
        this.longitude = longitude;
        this.latitude = latitude;
        this.webLinks = webLinks;
    }

    public Journal(Long id, String title, String text, String time, String longitude, String latitude, String webLinks) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.time = time;
        this.longitude = longitude;
        this.latitude = latitude;
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
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setWebLinks(String webLinks) {
        this.webLinks = webLinks;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }

    public Travel getTravel() {
        return travel;
    }

    @Override
    public String toString() {
        return title;
    }
}
