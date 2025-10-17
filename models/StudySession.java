package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a study session for a specific course.
 * 
 * A study session is created by a student (the creator) for a specific course
 * at a scheduled time. Other students can be invited to join the session.
 * Sessions have a maximum capacity of 5 participants.
 * 
 * The class provides methods to:
 * - Add participants to the session (with availability checking)
 * - Remove participants (except the creator)
 * - Display session details
 * 
 * @author StudyBuddy Team
 * @version 1.0
 */
public class StudySession {
    private static final int MAX_CAPACITY = 5;
    
    private Student creator;                // Student who created the session
    private String course;                  // Course name or code
    private String time;                    // Scheduled time (format: "DayOfWeek TimeSlot")
    private List<Student> participants;     // List of all participants

    /**
     * Constructs a new StudySession.
     * The creator is automatically added as the first participant.
     * 
     * @param creator The student creating the session
     * @param course The course name or code (e.g., "CPSC 2150")
     * @param time The scheduled time (e.g., "Monday 7PM-8PM")
     */
    public StudySession(Student creator, String course, String time) {
        this.creator = creator;
        this.course = course;
        this.time = time;
        this.participants = new ArrayList<>();
        this.participants.add(creator);
    }

    /**
     * Attempts to add a student to the study session.
     * 
     * The student will only be added if:
     * - The session is not full (max 5 participants)
     * - The student is not already in the session
     * - The student is available at the session's time
     * 
     * @param student The student to add to the session
     * @return A message indicating the result of the operation
     */
    public String addParticipant(Student student) {
        if (participants.size() >= MAX_CAPACITY) {
            return "⚠️ This study session is already full (max " + MAX_CAPACITY + " participants).";
        }

        if (participants.contains(student)) {
            return "⚠️ " + student.getName() + " is already in the study session.";
        }

        // Parse time format: "DayOfWeek TimeSlot" (e.g., "Monday 2PM-4PM")
        String[] parts = time.split(" ", 2);
        if (parts.length == 2 && student.isFreeAt(parts[0], parts[1])) {
            participants.add(student);
            return "✅ " + student.getName() + " has accepted the invitation and was added to the study session.";
        } else {
            return "❌ " + student.getName() + " has declined the invitation (not available at this time).";
        }
    }

    /**
     * Removes a student from the study session.
     * The creator cannot be removed from their own session.
     * 
     * @param student The student to remove
     */
    public void removeParticipant(Student student) {
        if (student.equals(creator)) {
            System.out.println("Cannot remove the creator from the study session.");
        } else if (participants.contains(student)) {
            participants.remove(student);
            System.out.println(student.getName() + " has been removed from the study session.");
        } else {
            System.out.println("Cannot remove " + student.getName() + " - not in the session.");
        }
    }

    /**
     * Displays detailed information about the study session to the console.
     * Shows the course, time, creator, and all participants.
     */
    public void displaySessionInfo() {
        System.out.println("Study Session for: " + course);
        System.out.println("Time: " + time);
        System.out.println("Creator: " + creator.getName());
        System.out.println("Participants (" + participants.size() + "/" + MAX_CAPACITY + "):");
        for (Student student : participants) {
            System.out.println(" - " + student.getName());
        }
    }

    /**
     * Gets the creator of the study session.
     * @return The Student who created the session
     */
    public Student getCreator() {
        return creator;
    }

    /**
     * Gets the course for this study session.
     * @return The course name or code
     */
    public String getCourse() {
        return course;
    }

    /**
     * Gets the scheduled time for this study session.
     * @return The time string in format "DayOfWeek TimeSlot"
     */
    public String getTime() {
        return time;
    }

    /**
     * Gets the list of all participants in the session.
     * @return List of Student objects
     */
    public List<Student> getParticipants() {
        return participants;
    }
}
