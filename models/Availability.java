package models;

public class Availability {


    private String dayOfWeek;   // e.g. "Monday"
    private String timeSlot;    // e.g. "2PM-4PM"

    public Availability(String dayOfWeek, String timeSlot) {
        this.dayOfWeek = dayOfWeek;
        this.timeSlot = timeSlot;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    @Override
    public String toString() {
        return dayOfWeek + " " + timeSlot;
    }

    // This lets us compare availabilities (important for removing)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Availability)) return false;
        Availability other = (Availability) obj;
        return dayOfWeek.equalsIgnoreCase(other.dayOfWeek) &&
                timeSlot.equalsIgnoreCase(other.timeSlot);
    }

    @Override
    public int hashCode() {
        return dayOfWeek.toLowerCase().hashCode() + timeSlot.toLowerCase().hashCode();
    }
}


