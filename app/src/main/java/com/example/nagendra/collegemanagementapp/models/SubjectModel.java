package com.example.nagendra.collegemanagementapp.models;

public class SubjectModel {

    String subjectname,chapters,nooftest,noofperiods,date;

    public SubjectModel() {
    }

    public SubjectModel(String subjectname, String chapters, String nooftest, String noofperiods, String date) {
        this.subjectname = subjectname;
        this.chapters = chapters;
        this.nooftest = nooftest;
        this.noofperiods = noofperiods;
        this.date = date;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public String getChapters() {
        return chapters;
    }

    public void setChapters(String chapters) {
        this.chapters = chapters;
    }

    public String getNooftest() {
        return nooftest;
    }

    public void setNooftest(String nooftest) {
        this.nooftest = nooftest;
    }

    public String getNoofperiods() {
        return noofperiods;
    }

    public void setNoofperiods(String noofperiods) {
        this.noofperiods = noofperiods;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
