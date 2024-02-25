package com.driver;

public class Student {
    private String studentName;
    private String email;

    public Student(String studentName, String email) {
        this.studentName = studentName;
        this.email = email;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getEmail() {
        return email;
    }
}