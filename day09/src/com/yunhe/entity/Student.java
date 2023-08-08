package com.yunhe.entity;

public class Student {
    private int studentid;
    private int studentage;
    private int classid;
    private String studentname;
    private String studentsex;
    private String studentaddress;

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public int getStudentage() {
        return studentage;
    }

    public void setStudentage(int studentage) {
        this.studentage = studentage;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getStudentsex() {
        return studentsex;
    }

    public void setStudentsex(String studentsex) {
        this.studentsex = studentsex;
    }

    public String getStudentaddress() {
        return studentaddress;
    }

    public void setStudentaddress(String studentaddress) {
        this.studentaddress = studentaddress;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentid=" + studentid +
                ", studentage=" + studentage +
                ", classid=" + classid +
                ", studentname='" + studentname + '\'' +
                ", studentsex='" + studentsex + '\'' +
                ", studentaddress='" + studentaddress + '\'' +
                '}';
    }

    public Student() {
    }

    public Student(int studentid, int studentage, int classid, String studentname, String studentsex, String studentaddress) {
        this.studentid = studentid;
        this.studentage = studentage;
        this.classid = classid;
        this.studentname = studentname;
        this.studentsex = studentsex;
        this.studentaddress = studentaddress;
    }
}
