package models;

import java.util.ArrayList;
import java.util.List;

/**
 * The StudySession class represents a study session that a student can create
 * for a specific course at a scheduled time.
 *
 * A study session always has:
 *  - A creator (the student who organized it).
 *  - A course name/ID.
 *  - A scheduled time.
 *  - A list of participants (including the creator).
 *
 * The class provides methods to:
 *  - Add classmates to the session.
 *  - Remove participants (except the creator).
 *  - Display session details (course, time, creator, participants).
 *
 * Example usage:
 *   StudySession session = new StudySession(alice, "CPSC 2150", "7:00 PM");
 *   session.addParticipant(bob);
 *   session.displaySessionInfo();
 */

public class StudySession {
    private Student creator;                // Who created the session
    private String course;                  // Course name/ID
    private String time;                    // Time of session
    private List<Student> participants;     // Invited classmates

    // Constructor
    public StudySession(Student creator, String course, String time) {
        this.creator = creator;
        this.course = course;
        this.time = time;
        this.participants = new ArrayList<>();
        this.participants.add(creator); // Creator is always part of the session
    }

    // Add a classmate
    public void addParticipant(Student student) {
        if (!participants.contains(student)) {
            participants.add(student);
            System.out.println(student.getName() + " has been added to the study session.");
        } else {
            System.out.println(student.getName() + " is already in the study session.");
        }
    }

    // Remove a classmate
    public void removeParticipant(Student student) {
        if (participants.contains(student) && !student.equals(creator)) {
            participants.remove(student);
            System.out.println(student.getName() + " has been removed from the study session.");
        } else {
            System.out.println("Cannot remove " + student.getName() + ".");
        }
    }

    // Display session details
    public void displaySessionInfo() {
        System.out.println("Study Session for: " + course);
        System.out.println("Time: " + time);
        System.out.println("Creator: " + creator.getName());
        System.out.println("Participants:");
        for (Student s : participants) {
            System.out.println(" - " + s.getName());
        }
    }

    // Getters (if needed)
    public Student getCreator() {
        return creator;
    }

    public String getCourse() {
        return course;
    }

    public String getTime() {
        return time;
    }

    public List<Student> getParticipants() {
        return participants;
    }
}
