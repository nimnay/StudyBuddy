package views;

import models.Student;

import java.util.List;
import java.util.Scanner;

import models.StudySession;

public class StudyBuddyMain {
    public static void main(String[] args) {

        String name, major;
        Scanner scanner = new Scanner(System.in);

        // Allowed majors (Clemson codes)
        java.util.Map<String, String> allowedMajors = new java.util.LinkedHashMap<>();
        allowedMajors.put("cpsc", "Computer Science");
        allowedMajors.put("bioch", "Biochemistry");
        allowedMajors.put("cheme", "Chemical Engineering");
        allowedMajors.put("ce", "Civil Engineering");
        allowedMajors.put("me", "Mechanical Engineering");
        allowedMajors.put("ee", "Electrical Engineering");
        allowedMajors.put("math", "Mathematics");
        allowedMajors.put("phys", "Physics");
        allowedMajors.put("bio", "Biology");
        allowedMajors.put("chem", "Chemistry");
        allowedMajors.put("stat", "Statistics");
        allowedMajors.put("econ", "Economics");
        allowedMajors.put("acct", "Accounting");
        allowedMajors.put("fin", "Finance");
        allowedMajors.put("mktg", "Marketing");
        allowedMajors.put("mgmt", "Management");
        allowedMajors.put("nurs", "Nursing");
        allowedMajors.put("eng", "English");
        allowedMajors.put("hist", "History");
        allowedMajors.put("psych", "Psychology");
        allowedMajors.put("soc", "Sociology");
        allowedMajors.put("anth", "Anthropology");
        allowedMajors.put("philos", "Philosophy");
        allowedMajors.put("art", "Art");
        allowedMajors.put("music", "Music");
        allowedMajors.put("ed", "Education");
        allowedMajors.put("poli", "Political Science");
        allowedMajors.put("comm", "Communication");

        // Setup directories and load data
        controller.StudentDirectory studentDirectory = new controller.StudentDirectory();
        studentDirectory.loadFakeStudents();
        controller.SessionDirectory sessionDirectory = new controller.SessionDirectory();
        sessionDirectory.loadSampleSessions(studentDirectory);

        System.out.println("Welcome to StudyBuddy! Let's create your profile to get started.\n");

        System.out.print("Enter your full name (first and last): ");
        name = scanner.nextLine();
        //scanner.nextLine(); // consume trailing newline

        // Validate major input
        while (true) {
            System.out.println("Enter your major. Choose from the following codes:");
            for (java.util.Map.Entry<String, String> entry : allowedMajors.entrySet()) {
                System.out.printf("  %s = %s\n", entry.getKey(), entry.getValue());
            }
            System.out.print("Major code: ");
            major = scanner.nextLine().trim();
            if (allowedMajors.containsKey(major.toLowerCase())) {
                break;
            } else {
                System.out.println("❌ Invalid major code. Please enter one of the listed codes.");
            }
        }

        //Student ourStudent = new Student(name, major);
        Student ourStudent = new Student(name, allowedMajors.get(major));

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
            System.out.println("3. Update availability");
            System.out.println("5. View Profile");
            System.out.println("6. Browse Students");
            System.out.println("7. Create Study Session");
            System.out.println("8. Join a Study Session"); // CHANGE TO JOIN A STUDY SESSION
            System.out.println("9. Browse study sessions");
            System.out.println("10. View Suggested Sessions");
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
                    System.out.println("Updated Courses: ");
                    ourStudent.printCourses();
                    break;
                }
                case 2: {
                    System.out.print("Enter course to remove: ");
                    String course = scanner.nextLine();
                    ourStudent.removeCourse(course);
                    System.out.println("Updated Courses: ");
                    ourStudent.printCourses();
                    break;
                }
                case 3: {
                    boolean browsing = true;
                    while (browsing) {
                        System.out.println("----Update availability----");
                        System.out.println("1. Add availability");
                        System.out.println("2. Remove availability");
                        System.out.println("3. Back to Main Menu");
                        System.out.print("Choose an option: ");
                        int browseChoice = scanner.nextInt();
                        scanner.nextLine(); // consume newline

                        switch (browseChoice) {
                            case 1: {
                                System.out.print("Enter day of week to add: ");
                                String day = scanner.nextLine();
                                System.out.print("Enter time slot: ");
                                String time = scanner.nextLine();
                                ourStudent.addAvailability(day, time);
                                System.out.println("Updated Availabilities:");
                                ourStudent.printAvailabilities();
                                break;
                            }
                            case 2: {
                                System.out.print("Enter day of week to remove: ");
                                String day = scanner.nextLine();
                                System.out.print("Enter time slot to remove: ");
                                String time = scanner.nextLine();
                                ourStudent.removeAvailability(day, time);
                                System.out.println("Updated Availabilities:");
                                ourStudent.printAvailabilities();
                                break;
                            }
                            case 3: {
                                browsing = false;
                                break;
                            }
                            default: {
                                System.out.println("Invalid choice. Try again.");
                            }
                        }
                    }
                }
                case 4: {
                    System.out.print("Enter day of week to remove: ");
                    String day = scanner.nextLine();
                    System.out.print("Enter time slot to remove: ");
                    String time = scanner.nextLine();
                    ourStudent.removeAvailability(day, time);
                    System.out.println("Updated Availabilities:");
                    ourStudent.printAvailabilities();
                    break;
                }
                case 5: {
                    System.out.println("\n=== Profile ===");
                    System.out.println("Name: " + ourStudent.getName());
                    System.out.println("Major: " + ourStudent.getMajor());
                    ourStudent.printCourses();
                    ourStudent.printAvailabilities();
                    System.out.println("\n=== Sessions You're In ===");
                    List<StudySession> allSessions = sessionDirectory.getSessions();
                    boolean found = false;
                    for (StudySession s : allSessions) {
                        for (Student p : s.getParticipants()) {
                            if (p.getName().equalsIgnoreCase(ourStudent.getName())) {
                                System.out.println("- " + s.getCourse() + " | Host: " + s.getCreator().getName() + " | " + s.getTime());
                                found = true;
                                break;
                            }
                        }
                    }
                    if (!found) {
                        System.out.println("You are not currently in any sessions.");
                    }
                    break;
                }
                case 6: {
                    boolean browsing = true;
                    while (browsing) {
                        System.out.println("\n--- Browse Students ---");
                        System.out.println("1. Browse by Course");
                        System.out.println("2. Browse by Major");
                        System.out.println("3. See All Students");
                        System.out.println("4. Back to Main Menu");
                        System.out.print("Choose an option: ");
                        int browseChoice = scanner.nextInt();
                        scanner.nextLine(); // consume newline

                        switch (browseChoice) {
                            case 1: { // by course
                                System.out.print("Enter course code (e.g. CS101): ");
                                String course = scanner.nextLine();
                                List<Student> byCourse = studentDirectory.findByCourse(course);
                                if (byCourse.isEmpty()) {
                                    System.out.println("No students found for " + course);
                                } else {
                                    System.out.println("Students in " + course + ":");
                                    for (Student s : byCourse) {
                                        System.out.println( s.getName() + " (" + s.getMajor() + ")");
                                    }
                                }
                                break;
                            }
                            case 2: { // by major
                                System.out.print("Enter major (e.g. ComputerScience): ");
                                String majorInput = scanner.nextLine();
                                List<Student> byMajor = studentDirectory.getStudentsByMajor(majorInput);
                                if (byMajor.isEmpty()) {
                                    System.out.println("No students found in " + majorInput);
                                } else {
                                    System.out.println("Students in " + majorInput + ":");
                                    for (Student s : byMajor) {
                                        System.out.println(s.getName() + " (" + s.getMajor() + ")");
                                    }
                                }
                                break;
                            }
                            case 3: { // all students
                                System.out.println("All registered students:");
                                for (Student s : studentDirectory.getAllStudents()) {
                                    System.out.println(s.getName() + " (" + s.getMajor() + ")");
                                }
                                break;
                            }
                            case 4: {
                                browsing = false; // exit submenu
                                break;
                            }
                            default: {
                                System.out.println("Invalid choice. Try again.");
                            }
                        }
                    }

                   // System.out.println("\n=== All Students ===");
                    //studentDirectory.printStudents();
                    break;
                }
              /*  case 7: {
                    System.out.println("Which class do you want to search? ");
                    String course = scanner.nextLine();
                    List<Student> classmates = studentDirectory.findByCourse(course);

                    if (classmates.isEmpty()) {
                        System.out.println("No students found in " + course);
                    } else {
                        System.out.println("Classmates in " + course + ":");
                        for (Student s : classmates) {
                            System.out.println(" - " + s.getName() + " (" + s.getMajor() + ")");
                        }
                    }
                    break;
                }

               */
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

                    while (true) {
                        System.out.print("Enter name of participant to invite (or type 'done' to finish): ");
                        String participantName = scanner.nextLine();

                        if (participantName.equalsIgnoreCase("done")) {
                            break;
                        }

                        Student participant = studentDirectory.findStudentByName(participantName);

                        if (participant == null) {
                            System.out.println("No student found with that name.");
                            continue; // go back and ask again
                        }

                        // Student found in directory, now confirm invite
                        System.out.println("Found: " + participant.getName() + ", Major: " + participant.getMajor());
                        System.out.print("Invite this student? (y/n): ");
                        String confirm = scanner.nextLine();

                        if (confirm.equalsIgnoreCase("y")) {
                            String result = session.addParticipant(participant);
                            System.out.println(result);
                        } else {
                            System.out.println("Skipped inviting " + participant.getName());
                        }
                    }
                    //Save study session to directory
                    sessionDirectory.addSession(session);
                    //Print confirmation information
                    System.out.println("STUDY SESSION CONFIRMATION DETAILS:");
                    session.displaySessionInfo();
                    break;
                }
                case 8: {
                    System.out.println("\n📚 Join a Study Session");

                    // Show all sessions first
                    List<StudySession> sessions = sessionDirectory.getSessions();

                    if (sessions.isEmpty()) {
                        System.out.println("No sessions available to join at the moment.");
                        break;
                    }

                    System.out.println("=== All Study Sessions ===");
                    for (int i = 0; i < sessions.size(); i++) {
                        StudySession s = sessions.get(i);
                        System.out.println((i + 1) + ". " + s.getCourse() + " | Host: "
                                + s.getCreator().getName() + " | " + s.getTime());
                    }

                    System.out.print("Enter the number of the session to join: ");
                    int sessionNum;
                    try {
                        sessionNum = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Returning to menu.");
                        break;
                    }

                    if (sessionNum < 1 || sessionNum > sessions.size()) {
                        System.out.println("Invalid session number.");
                        break;
                    }

                    StudySession selectedSession = sessions.get(sessionNum - 1);

                    // Split day and time from session.getTime()
                    String[] parts = selectedSession.getTime().split(" ", 2);
                    String day = parts[0];     // e.g., "Monday"
                    String time = parts[1];    // e.g., "3PM"

                    // Now check if student is free at this day/time
                    if (!ourStudent.isFreeAt(day, time)) {
                        System.out.println("⚠️ You are not available at this time. Please update your availability first.");
                        break;
                    }

                    // Show confirmation
                    System.out.println("You selected: " + selectedSession.getCourse() +
                            " | Host: " + selectedSession.getCreator().getName() +
                            " | " + selectedSession.getTime());

                    System.out.print("Confirm join? (y/n): ");
                    String confirm = scanner.nextLine();

                    if (confirm.equalsIgnoreCase("y")) {
                        System.out.println(selectedSession.addParticipant(ourStudent));
                    } else {
                        System.out.println("Cancelled joining session.");
                    }
                    break;
                }
                case 9: {
                    System.out.println("All Study Sessions:");
                    sessionDirectory.printSessions();
                    break;
                }
                case 10: {
                    System.out.println("Here are the Suggested Sessions based on your classes:");
                    List<StudySession> allSessions = sessionDirectory.getSessions();
                    List<String> myCourses = ourStudent.getCourses();
                    java.util.List<StudySession> suggested = new java.util.ArrayList<>();
                    for (StudySession s : allSessions) {
                        for (String c : myCourses) {
                            if (s.getCourse().equalsIgnoreCase(c)) {
                                suggested.add(s);
                                break;
                            }
                        }
                    }
                    if (suggested.isEmpty()) {
                        System.out.println("No suggested sessions found for your courses.");
                        break;
                    }
                    for (int i = 0; i < suggested.size(); i++) {
                        StudySession s = suggested.get(i);
                        System.out.println((i + 1) + ". " + s.getCourse() + " | Host: " + s.getCreator().getName() + " | " + s.getTime());
                    }
                    System.out.print("Enter the number of the session to join (or 0 to cancel): ");
                    int sessionNum;
                    try {
                        sessionNum = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Returning to menu.");
                        break;
                    }
                    if (sessionNum == 0) {
                        System.out.println("Cancelled.");
                        break;
                    }
                    if (sessionNum < 1 || sessionNum > suggested.size()) {
                        System.out.println("Invalid session number.");
                        break;
                    }
                    StudySession selectedSession = suggested.get(sessionNum - 1);
                    String[] parts = selectedSession.getTime().split(" ", 2);
                    String day = parts[0];
                    String time = parts[1];
                    if (!ourStudent.isFreeAt(day, time)) {
                        System.out.println("⚠️ You are not available at this time. Please update your availability first.");
                        break;
                    }
                    System.out.println("You selected: " + selectedSession.getCourse() +
                            " | Host: " + selectedSession.getCreator().getName() +
                            " | " + selectedSession.getTime());
                    System.out.print("Confirm join? (y/n): ");
                    String confirm = scanner.nextLine();
                    if (confirm.equalsIgnoreCase("y")) {
                        System.out.println(selectedSession.addParticipant(ourStudent));
                    } else {
                        System.out.println("Cancelled joining session.");
                    }
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


