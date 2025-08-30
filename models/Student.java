package models;
import java.util.ArrayList;
import java.util.List;


public class Student {
    // Student.java

    private String name;
    private String major;
    private List<String> courses;
    private List<models.Availability> availabilities;

    public Student(String name, String major) {
        this.name = name;
        this.major = major;
        this.courses = new ArrayList<>();
        this.availabilities = new ArrayList<>();
    }

    public String getName() {
            return name;
    }

    public String getMajor() { return major;}

    public List<models.Availability> getAvailabilities() {
        return availabilities;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void addCourse(String course) {
        if (!courses.contains(course)) {
            courses.add(course);
        } else {
            System.out.println("That course is already enrolled.");
        }
    }

    public void removeCourse(String course) {
        if (courses.remove(course)) {
        } else {
            System.out.println("Course not found.");
        }
    }

        // Story 2.1 - Add availability
    public void addAvailability(String dayOfWeek, String timeSlot) {
        Availability newSlot = new Availability(dayOfWeek, timeSlot);
        if (!availabilities.contains(newSlot)) {
            availabilities.add(newSlot);
        }
    }

    // Story 2.2 - Remove availability
    public void removeAvailability(String dayOfWeek, String timeSlot) {
        Availability slotToRemove = new Availability(dayOfWeek, timeSlot);
        if (availabilities.remove(slotToRemove)) {
        } else {
            System.out.println("Availability not found.");
        }
    }


    /**
     * Checks if the student is free at the given day and time slot.
     * @param dayOfWeek The day to check (e.g., "Monday")
     * @param timeSlot The time slot to check (e.g., "2PM-4PM")
     * @return true if the student is available at that time, false otherwise
     */
    public boolean isFreeAt(String day, String sessionTime) {
        for (Availability availability : availabilities) {
            if (availability.getDayOfWeek().equalsIgnoreCase(day)) {
                // Compare time ranges
                if (timeOverlaps(availability.getTimeSlot(), sessionTime)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean timeOverlaps(String availabilityTime, String sessionTime) {
        // availabilityTime and sessionTime look like "6PM-8PM"
        String[] availRange = availabilityTime.split("-");
        String[] sessionRange = sessionTime.split("-");
        if (availRange.length == 2 && sessionRange.length == 2) {
            int availStart = convertTo24Hour(availRange[0].trim());
            int availEnd   = convertTo24Hour(availRange[1].trim());
            int sessionStart = convertTo24Hour(sessionRange[0].trim());
            int sessionEnd   = convertTo24Hour(sessionRange[1].trim());

            // check if session fits in availability
            return sessionStart >= availStart && sessionEnd <= availEnd;
        }
        return false;
    }

    private int convertTo24Hour(String time) {
        // crude parser: "6PM" -> 18, "10AM" -> 10
        int hour = Integer.parseInt(time.replaceAll("[^0-9]", ""));
        if (time.contains("PM") && hour != 12) hour += 12;
        if (time.contains("AM") && hour == 12) hour = 0;
        return hour;
    }
    // Helper to show courses
    public void printCourses() {
        if (courses.isEmpty()) {
            System.out.println(name + " is not enrolled in any courses.");
        } else {
            System.out.println(name + "'s Courses:");
            for (String c : courses) {
                System.out.println(" - " + c);
            }
        }
    }
    // Helper to show availabilities
    public void printAvailabilities() {
        if (availabilities.isEmpty()) {
            System.out.println(name + " has no availability set.");
        } else {
            System.out.println(name + "'s Availability:");
            for (Availability a : availabilities) {
                System.out.println(" - " + a);
            }
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", courses=" + courses + '\'' +
                ", availability" + availabilities +
                '}';
    }
}

