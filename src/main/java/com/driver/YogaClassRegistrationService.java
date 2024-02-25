package com.driver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YogaClassRegistrationService {
    private Map<String, YogaClass> yogaClasses;

    public YogaClassRegistrationService() {
        this.yogaClasses = new HashMap<>();
    }

    public void registerStudent(StudentDTO studentDTO, YogaClassDTO yogaClassDTO) {
        YogaClass yogaClass = yogaClasses.get(yogaClassDTO.getClassCode());

        if (yogaClass == null) {
            System.out.println("Class not found. First Add New Yoga Class");
            return;
        }

        Student student = new Student(studentDTO.getStudentName(), studentDTO.getEmail());

        try {
            yogaClass.enrollStudent(student);
            System.out.println("Student " + student.getStudentName() + " successfully enrolled in class "
                    + yogaClass.getClassCode());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addYogaClass(YogaClassDTO yogaClassDTO) {
        YogaClass yogaClass = new YogaClass(yogaClassDTO.getClassCode(),
                yogaClassDTO.getInstructor(),
                yogaClassDTO.getMaxCapacity(),
                yogaClassDTO.getFormType());

        yogaClasses.put(yogaClass.getClassCode(), yogaClass);
        System.out.println("Class " + yogaClass.getClassCode() + " added successfully.");
    }

    public void displayEnrolledStudents(String classCode) {
        YogaClass yogaClass = yogaClasses.get(classCode);

        if (yogaClass == null) {
            System.out.println("Invalid class code. Class not found.");
            return;
        }

        List<Student> enrolledStudents = yogaClass.getEnrolledStudents();

        if (enrolledStudents.isEmpty()) {
            System.out.println("No students enrolled in class " + classCode);
        } else {
            System.out.println("Enrolled students in class " + classCode + ":");
            enrolledStudents.forEach(student -> System.out.println(student.getStudentName()));
        }
    }
}