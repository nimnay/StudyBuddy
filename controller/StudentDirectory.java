package controller;

import models.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages all students in the StudyBuddy application.
 * 
 * The StudentDirectory provides a centralized location for managing both
 * real users and preloaded sample students. It offers methods to add,
 * find, and retrieve students, making it easy to integrate with other
 * components like StudySession for invitations.
 * 
 * @author StudyBuddy Team
 * @version 1.0
 */
public class StudentDirectory {
    private List<Student> students;

    /**
     * Constructs a new StudentDirectory with an empty student list.
     */
    public StudentDirectory() {
        this.students = new ArrayList<>();
    }

    /**
     * Loads sample student data into the directory.
     * Creates 5 fake students with various majors, courses, and availabilities
     * for testing and demonstration purposes.
     * 
     * In production, this could be replaced with loading from a database or file.
     */
    public void loadFakeStudents() {
        Student s1 = new Student("Bob", "Computer Science");
        s1.addCourse("CPSC 2150");
        s1.addAvailability("Monday", "7PM-8PM");

        Student s2 = new Student("Charlie", "Mathematics");
        s2.addCourse("MATH 2080");
        s2.addAvailability("Monday", "7PM-8PM");

        Student s3 = new Student("Dana", "Physics");
        s3.addCourse("PHYS 1010");
        s3.addAvailability("Tuesday", "6PM-7PM");

        Student s4 = new Student("Emily", "Biology");
        s4.addCourse("BIOL 1030");
        s4.addCourse("CHEM 1010");
        s4.addAvailability("Wednesday", "10AM-12PM");
        s4.addAvailability("Friday", "2PM-4PM");

        Student s5 = new Student("Frank", "Engineering");
        s5.addCourse("ENGR 1410");
        s5.addCourse("MATH 1060");
        s5.addAvailability("Monday", "7PM-8PM");
        s5.addAvailability("Thursday", "1PM-3PM");

        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
    }

    /**
     * Adds a new student to the directory.
     * Used when a real user creates a profile.
     * 
     * @param student The Student object to add
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Finds a student by name (case-insensitive).
     * 
     * @param name The student's name to search for
     * @return The Student object if found, null otherwise
     */
    public Student findStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }


    /**
     * Lists students taking the specified course.
     * @param course The course to search for
     * @return List of students enrolled in the course
     */
    public List<Student> findByCourse(String course) {
    /**
     * Finds all students enrolled in a specific course.
     * 
     * @param course The course code or name to search for
     * @return List of students taking the specified course
     */
    public List<Student> getStudentsByCourse(String course) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getCourses().contains(course)) {
                result.add(student);
            }
        }
        return result;
    }

    /**
     * Gets all students in the directory.
     * 
     * @return List of all Student objects
     */
    public List<Student> getAllStudents() {
        return students;
    }

    /**
     * Prints all students in the directory with their details.
     * Displays name, major, courses, and availabilities for each student.
     */
    public void printStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the directory.");
            return;
        }
        
        for (Student student : students) {
            System.out.println("Name: " + student.getName());
            System.out.println("  Major: " + student.getMajor());
            System.out.print("  Courses: ");
            
            if (student.getCourses().isEmpty()) {
                System.out.print("None");
            } else {
                System.out.print(String.join(", ", student.getCourses()));
            }
            
            System.out.println();
            System.out.print("  Availabilities: ");
            
            if (student.getAvailabilities().isEmpty()) {
                System.out.print("None");
            } else {
                for (models.Availability availability : student.getAvailabilities()) {
                    System.out.print(availability.toString() + " ");
                }
            }
            System.out.println("\n");
        }
    }

    /**
     * Finds all students with a specific major (case-insensitive).
     * 
     * @param major The major to search for
     * @return List of students with the given major
     */
    public List<Student> getStudentsByMajor(String major) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getMajor().equalsIgnoreCase(major)) {
                result.add(student);
            }
        }
        return result;
    }
}