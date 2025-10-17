package models;

/**
 * Represents a time slot when a student is available for study sessions.
 * Each availability consists of a day of the week and a time range.
 * 
 * @author StudyBuddy Team
 * @version 1.0
 */
public class Availability {
    private String dayOfWeek;   // e.g., "Monday"
    private String timeSlot;    // e.g., "2PM-4PM"

    /**
     * Constructs a new Availability with the specified day and time slot.
     * 
     * @param dayOfWeek The day of the week (e.g., "Monday", "Tuesday")
     * @param timeSlot The time range in 12-hour format (e.g., "2PM-4PM")
     */
    public Availability(String dayOfWeek, String timeSlot) {
        this.dayOfWeek = dayOfWeek;
        this.timeSlot = timeSlot;
    }

    /**
     * Gets the day of the week for this availability.
     * @return The day of the week
     */
    public String getDayOfWeek() {
        return dayOfWeek;
    }

    /**
     * Gets the time slot for this availability.
     * @return The time range
     */
    public String getTimeSlot() {
        return timeSlot;
    }

    /**
     * Returns a string representation of this availability.
     * Format: "DayOfWeek TimeSlot" (e.g., "Monday 2PM-4PM")
     * 
     * @return A formatted string
     */
    @Override
    public String toString() {
        return dayOfWeek + " " + timeSlot;
    }

    /**
     * Compares this availability with another object for equality.
     * Two availabilities are equal if they have the same day and time slot (case-insensitive).
     * 
     * @param obj The object to compare with
     * @return true if the availabilities are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Availability)) return false;
        Availability other = (Availability) obj;
        return dayOfWeek.equalsIgnoreCase(other.dayOfWeek) &&
                timeSlot.equalsIgnoreCase(other.timeSlot);
    }

    /**
     * Returns a hash code for this availability.
     * Used for storing availabilities in hash-based collections.
     * 
     * @return The hash code
     */
    @Override
    public int hashCode() {
        return dayOfWeek.toLowerCase().hashCode() + timeSlot.toLowerCase().hashCode();
    }
}


