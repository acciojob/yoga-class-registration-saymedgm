package com.driver;

import java.util.Scanner;

public class YogaClassRegistrationController {
    private YogaClassRegistrationService registrationService;

    public YogaClassRegistrationController(YogaClassRegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    public void processUserInput() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registerStudent(scanner);
                    break;
                case 2:
                    addYogaClass(scanner);
                    break;
                case 3:
                    displayEnrolledStudents(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private void printMenu() {
        System.out.println("Choose an option:");
        System.out.println("1. Register Student for Yoga Class");
        System.out.println("2. Add New Yoga Class");
        System.out.println("3. Display Enrolled Students in a Yoga Class");
        System.out.println("4. Exit");
    }

    private void registerStudent(Scanner scanner) {
        System.out.println("Enter Student Name:");
        scanner.nextLine(); // Consume the newline character
        String studentName = scanner.nextLine();

        System.out.println("Enter Student Email:");
        String email = scanner.next();

        System.out.println("Enter Yoga Class Code:");
        String classCode = scanner.next();

        StudentDTO studentDTO = new StudentDTO(studentName, email);
        YogaClassDTO yogaClassDTO = new YogaClassDTO(classCode, "", 0, "");

        registrationService.registerStudent(studentDTO, yogaClassDTO);
    }

    private void addYogaClass(Scanner scanner) {
        System.out.println("Enter Yoga Class Code:");
        scanner.nextLine(); // Consume the newline character
        String classCode = scanner.nextLine();

        System.out.println("Enter Instructor Name:");
        String instructor = scanner.nextLine();

        System.out.println("Enter Max Capacity:");
        int maxCapacity = scanner.nextInt();

        System.out.println("Enter Form Type:");
        String formType = scanner.next();

        YogaClassDTO yogaClassDTO = new YogaClassDTO(classCode, instructor, maxCapacity, formType);
        registrationService.addYogaClass(yogaClassDTO);
    }

    private void displayEnrolledStudents(Scanner scanner) {
        System.out.println("Enter Yoga Class Code:");
        String classCode = scanner.next();
        registrationService.displayEnrolledStudents(classCode);
    }
    public static void main(String[] args) {
        // Create necessary objects and start the application
        YogaClassRegistrationService registrationService = new YogaClassRegistrationService();
        YogaClassRegistrationController registrationController = new YogaClassRegistrationController(registrationService);

        // Start processing user input
        registrationController.processUserInput();
    }
}
