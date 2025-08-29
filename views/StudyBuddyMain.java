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

        // Setup directories and load data
        controller.StudentDirectory studentDirectory = new controller.StudentDirectory();
        studentDirectory.loadFakeStudents();
        controller.SessionDirectory sessionDirectory = new controller.SessionDirectory();
        sessionDirectory.loadSampleSessions(studentDirectory);

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
            System.out.println("6. Browse Students");
            System.out.println("7. Create Study Session");
            System.out.println("8. Browse Study Sessions");
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
                    System.out.println("\n=== All Students ===");
                    studentDirectory.printStudents();
                    break;
                }
                case 7: {
                    System.out.println("\n📅 Create Study Session");
                    System.out.print("Enter course for the session: ");
                    String sessionCourse = scanner.nextLine();
                    System.out.print("Enter day of week for the session: ");
                    String sessionDay = scanner.nextLine();
                    System.out.print("Enter time slot for the session: ");
                    String sessionTime = scanner.nextLine();
                    String sessionDateTime = sessionDay + " " + sessionTime;
                    models.StudySession session = new models.StudySession(ourStudent, sessionCourse, sessionDateTime);

                    System.out.print("Enter name of participant to invite: ");
                    String participantName = scanner.nextLine();
                    System.out.print("Enter major of participant: ");
                    String participantMajor = scanner.nextLine();
                    models.Student participant = new models.Student(participantName, participantMajor);
                    System.out.println("Add availability for participant (at least one should match session time):");
                    boolean addAvail = true;
                    while (addAvail) {
                        System.out.print("Enter day of week (or 'done'): ");
                        String pDay = scanner.nextLine();
                        if (pDay.equalsIgnoreCase("done")) break;
                        System.out.print("Enter time slot: ");
                        String pTime = scanner.nextLine();
                        participant.addAvailability(pDay, pTime);
                    }
                    session.addParticipant(participant);
                    break;
                }
                case 8: {
                    System.out.println("\n=== All Study Sessions ===");
                    sessionDirectory.printSessions();
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


