package com.example.nagendra.collegemanagementapp.models;


public class TeacherModel {

    String teachername,teacherphonenumber,
            teachermailid,teacherid,teacherdepartment;

    public TeacherModel() {
    }

    public TeacherModel(String teachername, String teacherphonenumber, String teachermailid, String teacherid, String teacherdepartment) {
        this.teachername = teachername;
        this.teacherphonenumber = teacherphonenumber;
        this.teachermailid = teachermailid;
        this.teacherid = teacherid;
        this.teacherdepartment = teacherdepartment;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getTeacherphonenumber() {
        return teacherphonenumber;
    }

    public void setTeacherphonenumber(String teacherphonenumber) {
        this.teacherphonenumber = teacherphonenumber;
    }

    public String getTeachermailid() {
        return teachermailid;
    }

    public void setTeachermailid(String teachermailid) {
        this.teachermailid = teachermailid;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    public String getTeacherdepartment() {
        return teacherdepartment;
    }

    public void setTeacherdepartment(String teacherdepartment) {
        this.teacherdepartment = teacherdepartment;
    }
}
