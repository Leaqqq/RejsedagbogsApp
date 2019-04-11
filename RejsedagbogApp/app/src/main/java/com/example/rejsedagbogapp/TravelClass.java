package com.example.rejsedagbogapp;

import java.util.Date;

public class TravelClass {

    public String destination;
    public Date fromDate;
    public Date endDate;
    public String description;

    public TravelClass(String destination,Date fromDate, Date endDate, String description) {
       this.destination = destination;
        this.fromDate = fromDate;
        this.endDate = endDate;
        this.description = description;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Destination: " + destination + " From: " + fromDate + " To: " + endDate;
    }
}
