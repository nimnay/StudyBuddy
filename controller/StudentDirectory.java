package controller;

import models.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * StudentDirectory manages all students in the app, including both real users
 * and preloaded fake classmates. This class provides methods to add, find, and
 * retrieve students, making it easy to integrate with StudySession for invitations.
 */

public class StudentDirectory {
    private List<Student> students;

    // Constructor
    public StudentDirectory() {
        this.students = new ArrayList<>();
    }

    /**
     * Loads fake student data into the directory.
     * For simplicity, fake students are hardcoded.
     * Later, this could be replaced with reading from a JSON or CSV file.
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

        // Add fake students to directory
        students.add(s1);
        students.add(s2);
        students.add(s3);
    }

    /**
     * Add a new student to the directory (e.g., real user creating a profile)
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Find a student by name.
     * @param name The student's name
     * @return The Student object if found, otherwise null
     */
    public Student findStudentByName(String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Get all students in the directory.
     * @return List of all students
     */
    public List<Student> getAllStudents() {
        return students;
    }
}