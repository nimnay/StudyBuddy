package tests;

import models.Student;
import models.Availability;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TestStudent {

    @Test
    public void testValidStudentCreation() {
        Student s = new Student("Alice", "Computer Science");
        assertEquals("Alice", s.getName());
        assertEquals("Computer Science", s.getMajor());
        assertTrue(s.getCourses().isEmpty());
        assertTrue(s.getAvailabilities().isEmpty());
    }

    @Test
    public void testSetters() {
        Student s = new Student("Alice", "CS");
        s.setName("Bob");
        s.setMajor("Mathematics");

        assertEquals("Bob", s.getName());
        assertEquals("Mathematics", s.getMajor());
    }

    @Test
    public void testAddCourse() {
        Student s = new Student("Charlie", "Physics");
        s.addCourse("PHYS 1010");
        s.addCourse("PHYS 1010"); // duplicate, should not add

        List<String> courses = s.getCourses();
        assertEquals(1, courses.size());
        assertEquals("PHYS 1010", courses.get(0));
    }

    @Test
    public void testRemoveCourse() {
        Student s = new Student("Dana", "Chemistry");
        s.addCourse("CHEM 1100");
        s.removeCourse("CHEM 1100");
        s.removeCourse("CHEM 1100"); // should not throw

        assertTrue(s.getCourses().isEmpty());
    }

    @Test
    public void testAddAvailability() {
        Student s = new Student("Eli", "Biology");
        s.addAvailability("Monday", "2PM-4PM");
        s.addAvailability("Monday", "2PM-4PM"); // duplicate

        List<Availability> availabilities = s.getAvailabilities();
        assertEquals(1, availabilities.size());
        assertEquals("Monday", availabilities.get(0).getDayOfWeek());
        assertEquals("2PM-4PM", availabilities.get(0).getTimeSlot());
    }

    @Test
    public void testRemoveAvailability() {
        Student s = new Student("Fiona", "Economics");
        s.addAvailability("Tuesday", "10AM-12PM");
        s.removeAvailability("Tuesday", "10AM-12PM");
        s.removeAvailability("Tuesday", "10AM-12PM"); // should not throw

        assertTrue(s.getAvailabilities().isEmpty());
    }

    @Test
    public void testToStringContainsNameAndMajor() {
        Student s = new Student("George", "English");
        String output = s.toString();

        assertTrue(output.contains("George"));
        assertTrue(output.contains("English"));
    }
}
