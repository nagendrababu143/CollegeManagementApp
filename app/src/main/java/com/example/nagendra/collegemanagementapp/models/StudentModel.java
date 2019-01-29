package com.example.nagendra.collegemanagementapp.models;

public class StudentModel {

    String studentname,studentphonenumber,
            studentmailid,studentid,studentdepartment;

    public StudentModel() {
    }

    public StudentModel(String studentname, String studentphonenumber, String studentmailid, String studentid, String studentdepartment) {
        this.studentname = studentname;
        this.studentphonenumber = studentphonenumber;
        this.studentmailid = studentmailid;
        this.studentid = studentid;
        this.studentdepartment = studentdepartment;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getStudentphonenumber() {
        return studentphonenumber;
    }

    public void setStudentphonenumber(String studentphonenumber) {
        this.studentphonenumber = studentphonenumber;
    }

    public String getStudentmailid() {
        return studentmailid;
    }

    public void setStudentmailid(String studentmailid) {
        this.studentmailid = studentmailid;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getStudentdepartment() {
        return studentdepartment;
    }

    public void setStudentdepartment(String studentdepartment) {
        this.studentdepartment = studentdepartment;
    }
}
