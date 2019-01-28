package com.example.nagendra.collegemanagementapp.models;

public class HodModel {

    String hodname,hodphonenumber,hodmailid,hodid,hoddepartment;

    public HodModel() {
    }

    public HodModel(String hodname, String hodphonenumber, String hodmailid, String hodid, String hoddepartment) {
        this.hodname = hodname;
        this.hodphonenumber = hodphonenumber;
        this.hodmailid = hodmailid;
        this.hodid = hodid;
        this.hoddepartment = hoddepartment;
    }

    public String getHodname() {
        return hodname;
    }

    public void setHodname(String hodname) {
        this.hodname = hodname;
    }

    public String getHodphonenumber() {
        return hodphonenumber;
    }

    public void setHodphonenumber(String hodphonenumber) {
        this.hodphonenumber = hodphonenumber;
    }

    public String getHodmailid() {
        return hodmailid;
    }

    public void setHodmailid(String hodmailid) {
        this.hodmailid = hodmailid;
    }

    public String getHodid() {
        return hodid;
    }

    public void setHodid(String hodid) {
        this.hodid = hodid;
    }

    public String getHoddepartment() {
        return hoddepartment;
    }

    public void setHoddepartment(String hoddepartment) {
        this.hoddepartment = hoddepartment;
    }
}
