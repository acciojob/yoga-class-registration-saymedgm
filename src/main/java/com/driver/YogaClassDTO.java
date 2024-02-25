package com.driver;

public class YogaClassDTO {
    private String classCode;
    private String instructor;
    private int maxCapacity;
    private String formType;

    public YogaClassDTO(String classCode, String instructor, int maxCapacity, String formType) {
        this.classCode = classCode;
        this.instructor = instructor;
        this.maxCapacity = maxCapacity;
        this.formType = formType;
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
}