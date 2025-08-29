package views;

import models.Student;

import java.util.Scanner;

public class StudyBuddyMain {
    //Each feature in the sprint needs a corresponding change in the FE
    public static void main(String[] args) {

        String name, major;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to study buddy, lets create your profile to get started\n");
        System.out.println("Enter your name ");
        name = scanner.next();
        scanner.nextLine(); //removing trailing newline

        System.out.println("Enter your major");
        major = scanner.nextLine();

        Student ourStudent = new Student(name, major);

        System.out.println("\nNow let's add all your courses.");
        boolean addingCourses = true;
        while (addingCourses) {
            System.out.print("Enter a course (or type 'done' to finish): ");
            String course = scanner.nextLine().trim();

            if (course.equalsIgnoreCase("done")) {
                addingCourses = false;
            } else if (!course.isEmpty()) {
                ourStudent.addCourse(course);
            }
        }


        System.out.println("\nProfile created for " + ourStudent.getName() + " (" + ourStudent.getMajor() + ")");

        //menu to edit profile
        boolean running = true;
        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add course");
            System.out.println("2. Remove course");
            System.out.println("3. Add availability");
            System.out.println("4. Remove availability");
            System.out.println("5. Print courses");
            System.out.println("6. Print availabilities");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = -1;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
            } else {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1: {
                    System.out.print("Enter course to add: ");
                    String course = scanner.nextLine();
                    ourStudent.addCourse(course);
                    break;
                }
                case 2: {
                    System.out.print("Enter course to remove: ");
                    String course = scanner.nextLine();
                    ourStudent.removeCourse(course);
                    break;
                }
                case 3: {
                    System.out.print("Enter day of week: ");
                    String day = scanner.nextLine();
                    System.out.print("Enter time slot: ");
                    String time = scanner.nextLine();
                    ourStudent.addAvailability(day, time);
                    break;
                }
                case 4: {
                    System.out.print("Enter day of week to remove: ");
                    String day = scanner.nextLine();
                    System.out.print("Enter time slot to remove: ");
                    String time = scanner.nextLine();
                    ourStudent.removeAvailability(day, time);
                    break;
                }
                case 5:{
                    ourStudent.printCourses();
                    break;
                }
                case 6: {
                    ourStudent.printAvailabilities();
                    break;
                }
                case 0: {
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                }
                default: System.out.println("Invalid choice.");
            }
        }


/*

        // Create a student
        Student s1 = new Student("Alice", "Computer Science");

        // Test courses
        System.out.println("=== Testing Courses ===");
        s1.addCourse("CPSC 1010");
        s1.addCourse("CPSC 2150");
        s1.addCourse("CPSC 2150"); // duplicate test
        s1.printCourses();
        s1.removeCourse("CPSC 1010");
        s1.removeCourse("MATH 1080"); // not enrolled test
        s1.printCourses();

        // Test availabilities
        System.out.println("\n=== Testing Availabilities ===");
        s1.addAvailability("MWF", "8:00-8:50");
        s1.addAvailability("MWF", "9:05-9:55");
        s1.addAvailability("MWF", "9:05-9:55"); // duplicate test
        s1.printAvailabilities();
        s1.removeAvailability("MWF", "8:00-8:50");
        s1.removeAvailability("MWF", "10:10-11:00"); // not found test
        s1.printAvailabilities();

    }

 */
    }
}
