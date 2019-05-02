package com.example.rejsedagbogapp.Classes;

import java.util.Date;

public class Travel {
    public Long id;
    public String destination;
    public String fromDate;
    public String endDate;
    public String description;


    public Travel( String destination, String fromDate, String endDate, String description) {
        this.destination = destination;
        this.fromDate = fromDate;
        this.endDate = endDate;
        this.description = description;
    }
    public Travel(Long id, String destination, String fromDate, String endDate, String description) {
      this.id=id;
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

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Destination: " + destination + " From: " + fromDate + " To: " + endDate;
    }
}
