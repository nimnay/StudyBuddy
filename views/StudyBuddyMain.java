package views;

import models.Student;
import java.util.Scanner;

import java.util.Scanner;
import models.Student;
import java.util.Scanner;

public class StudyBuddyMain {
    public static void main(String[] args) {
        String name, major;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to StudyBuddy! Let's create your profile to get started.\n");

        System.out.print("Enter your name: ");
        name = scanner.next();
        scanner.nextLine(); // consume trailing newline

        System.out.print("Enter your major: ");
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

        System.out.println("\n✅ Profile created for " + ourStudent.getName() + " (" + ourStudent.getMajor() + ")");

        // menu loop
        boolean running = true;
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add course");
            System.out.println("2. Remove course");
            System.out.println("3. Add availability");
            System.out.println("4. Remove availability");
            System.out.println("5. View Profile");
            System.out.println("6. Create Study Session");
            System.out.println("7. Browse Study Sessions");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = -1;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
            } else {
                System.out.println("❌ Please enter a valid number.");
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
                case 5: {
                    System.out.println("\n=== Profile ===");
                    System.out.println("Name: " + ourStudent.getName());
                    System.out.println("Major: " + ourStudent.getMajor());
                    ourStudent.printCourses();
                    ourStudent.printAvailabilities();
                    break;
                }
                case 6: {
                    System.out.println("\n📅 Create Study Session feature coming soon...");
                    break;
                }
                case 7: {
                    System.out.println("\n🔍 Browse Study Sessions feature coming soon...");
                    break;
                }
                case 0: {
                    running = false;
                    System.out.println("👋 Goodbye!");
                    break;
                }
                default:
                    System.out.println("❌ Invalid choice.");
            }
        }

        scanner.close();
    }
}


