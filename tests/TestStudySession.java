package tests;

import models.Student;
import models.StudySession;
import org.junit.Test;

public class TestStudySession {
    @Test
    public void testAddParticipantAccepted() {
        Student alice = new Student("Alice", "CS");
        alice.addAvailability("Monday", "2PM-4PM");
        StudySession session = new StudySession(alice, "CPSC 3720", "Monday 2PM-4PM");

        Student bob = new Student("Bob", "CS");
        bob.addAvailability("Monday", "2PM-4PM");
        session.addParticipant(bob); // Should accept
    }

    @Test
    public void testAddParticipantDeclined() {
        Student alice = new Student("Alice", "CS");
        alice.addAvailability("Monday", "2PM-4PM");
        StudySession session = new StudySession(alice, "CPSC 3720", "Monday 2PM-4PM");

        Student charlie = new Student("Charlie", "CS");
        charlie.addAvailability("Tuesday", "2PM-4PM");
        session.addParticipant(charlie); // Should decline
    }

    @Test
    public void testAddParticipantAlreadyInSession() {
        Student alice = new Student("Alice", "CS");
        alice.addAvailability("Monday", "2PM-4PM");
        StudySession session = new StudySession(alice, "CPSC 3720", "Monday 2PM-4PM");

        session.addParticipant(alice); // Should say already in session
    }
}
