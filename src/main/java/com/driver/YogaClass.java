package com.driver;

import java.util.ArrayList;
import java.util.List;

public class YogaClass {
    private String classCode;
    private String instructor;
    private int maxCapacity;
    private String formType;
    private List<Student> enrolledStudents;

    public YogaClass(String classCode, String instructor, int maxCapacity, String formType) {
        this.classCode = classCode;
        this.instructor = instructor;
        this.maxCapacity = maxCapacity;
        this.formType = formType;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getClassCode() {
        return classCode;
    }

    public String getInstructor() {
        return instructor;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public String getFormType() {
        return formType;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void enrollStudent(Student student) {
        if (enrolledStudents.size() < maxCapacity) {
            enrolledStudents.add(student);
        } else {
            throw new RuntimeException("Class is already full. Cannot enroll more students.");
        }
    }
}