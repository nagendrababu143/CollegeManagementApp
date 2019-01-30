package com.example.nagendra.collegemanagementapp.models;

public class AddAssessmentModel {

    String studentname,testmarks,month,test;

    public AddAssessmentModel() {
    }

    public AddAssessmentModel(String studentname, String testmarks, String month, String test) {
        this.studentname = studentname;
        this.testmarks = testmarks;
        this.month = month;
        this.test = test;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getTestmarks() {
        return testmarks;
    }

    public void setTestmarks(String testmarks) {
        this.testmarks = testmarks;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
