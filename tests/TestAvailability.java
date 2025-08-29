package tests;


import models.Availability;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestAvailability {

    @Test
    public void testValidAvailability() {
        Availability a = new Availability("Monday", "2PM-4PM");
        assertEquals("Monday", a.getDayOfWeek());
        assertEquals("2PM-4PM", a.getTimeSlot());
        assertEquals("Monday 2PM-4PM", a.toString());
    }

    @Test
    public void testEqualsAndHashCode() {
        Availability a1 = new Availability("Tuesday", "10AM-12PM");
        Availability a2 = new Availability("tuesday", "10am-12pm");

        assertEquals(a1, a2);
        assertEquals(a1.hashCode(), a2.hashCode());
    }

    @Test
    public void testNotEquals() {
        Availability a1 = new Availability("Wednesday", "1PM-3PM");
        Availability a2 = new Availability("Thursday", "1PM-3PM");
        Availability a3 = new Availability("Wednesday", "3PM-5PM");

        assertNotEquals(a1, a2);
        assertNotEquals(a1, a3);
    }

    // 🚨 Future validation test cases 🚨
    @Test
    public void testInvalidDayOfWeek() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Availability("Funday", "2PM-4PM");
        });
        assertTrue(exception.getMessage().contains("Invalid day"));
    }

    @Test
    public void testEmptyDayOfWeek() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Availability("", "2PM-4PM");
        });
        assertTrue(exception.getMessage().contains("day"));
    }

    @Test
    public void testNullDayOfWeek() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Availability(null, "2PM-4PM");
        });
        assertTrue(exception.getMessage().contains("day"));
    }

    @Test
    public void testInvalidTimeSlotFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Availability("Monday", "25PM-30PM");
        });
        assertTrue(exception.getMessage().contains("time slot"));
    }

    @Test
    public void testEmptyTimeSlot() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Availability("Monday", "");
        });
        assertTrue(exception.getMessage().contains("time slot"));
    }

    @Test
    public void testNullTimeSlot() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Availability("Monday", null);
        });
        assertTrue(exception.getMessage().contains("time slot"));
    }
}
