package com.example.project_6thsem;

public class MainModel {
    String date,description,phone,time;
    MainModel()
    {

    }
    public MainModel(String date, String description, String phone, String time) {
        this.date = date;
        this.description = description;
        this.phone = phone;
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getPhone() {
        return phone;
    }

    public String getTime() {
        return time;
    }


}
