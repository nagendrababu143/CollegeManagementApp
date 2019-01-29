package com.example.nagendra.collegemanagementapp.models;

public class AttendanceModel {

    String name,month,day,status;

    public AttendanceModel() {
    }

    public AttendanceModel(String name, String month, String day, String status) {
        this.name = name;
        this.month = month;
        this.day = day;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
