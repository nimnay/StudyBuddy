package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a student in the StudyBuddy application.
 * Each student has a name, major, list of courses, and availability schedule.
 * Students can manage their courses, set availability times, and participate in study sessions.
 * 
 * @author StudyBuddy Team
 * @version 1.0
 */
public class Student {
    private String name;
    private String major;
    private List<String> courses;
    private List<Availability> availabilities;

    /**
     * Constructs a new Student with the specified name and major.
     * Initializes empty lists for courses and availabilities.
     * 
     * @param name The full name of the student
     * @param major The student's major field of study
     */
    public Student(String name, String major) {
        this.name = name;
        this.major = major;
        this.courses = new ArrayList<>();
        this.availabilities = new ArrayList<>();
    }

    /**
     * Gets the student's name.
     * @return The student's full name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the student's major.
     * @return The student's major field of study
     */
    public String getMajor() {
        return major;
    }

    /**
     * Gets the student's availability schedule.
     * @return List of Availability objects representing free time slots
     */
    public List<Availability> getAvailabilities() {
        return availabilities;
    }

    /**
     * Gets the list of courses the student is enrolled in.
     * @return List of course names/codes
     */
    public List<String> getCourses() {
        return courses;
    }

    /**
     * Sets the student's name.
     * @param name The new name for the student
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the student's major.
     * @param major The new major for the student
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * Adds a course to the student's course list.
     * Prevents duplicate course enrollments.
     * 
     * @param course The course code or name to add
     */
    public void addCourse(String course) {
        if (!courses.contains(course)) {
            courses.add(course);
        } else {
            System.out.println("That course is already enrolled.");
        }
    }

    /**
     * Removes a course from the student's course list.
     * 
     * @param course The course code or name to remove
     */
    public void removeCourse(String course) {
        if (!courses.remove(course)) {
            System.out.println("Course not found.");
        }
    }

    /**
     * Adds a time slot to the student's availability schedule.
     * Prevents duplicate availability entries.
     * 
     * @param dayOfWeek The day of the week (e.g., "Monday")
     * @param timeSlot The time range (e.g., "2PM-4PM")
     */
    public void addAvailability(String dayOfWeek, String timeSlot) {
        Availability newSlot = new Availability(dayOfWeek, timeSlot);
        if (!availabilities.contains(newSlot)) {
            availabilities.add(newSlot);
        }
    }

    /**
     * Removes a time slot from the student's availability schedule.
     * 
     * @param dayOfWeek The day of the week to remove
     * @param timeSlot The time range to remove
     */
    public void removeAvailability(String dayOfWeek, String timeSlot) {
        Availability slotToRemove = new Availability(dayOfWeek, timeSlot);
        if (!availabilities.remove(slotToRemove)) {
            System.out.println("Availability not found.");
        }
    }


    /**
     * Checks if the student is free at the given day and time slot.
     * 
     * @param day The day to check (e.g., "Monday")
     * @param sessionTime The time slot to check (e.g., "2PM-4PM")
     * @return true if the student is available at that time, false otherwise
     */
    public boolean isFreeAt(String day, String sessionTime) {
        for (Availability availability : availabilities) {
            if (availability.getDayOfWeek().equalsIgnoreCase(day)) {
                if (timeOverlaps(availability.getTimeSlot(), sessionTime)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if two time ranges overlap.
     * 
     * @param availabilityTime The student's available time range (e.g., "6PM-8PM")
     * @param sessionTime The session's time range (e.g., "7PM-8PM")
     * @return true if the session fits within the availability, false otherwise
     */
    private boolean timeOverlaps(String availabilityTime, String sessionTime) {
        String[] availRange = availabilityTime.split("-");
        String[] sessionRange = sessionTime.split("-");
        
        if (availRange.length == 2 && sessionRange.length == 2) {
            int availStart = convertTo24Hour(availRange[0].trim());
            int availEnd = convertTo24Hour(availRange[1].trim());
            int sessionStart = convertTo24Hour(sessionRange[0].trim());
            int sessionEnd = convertTo24Hour(sessionRange[1].trim());

            return sessionStart >= availStart && sessionEnd <= availEnd;
        }
        return false;
    }

    /**
     * Converts a 12-hour time format to 24-hour format.
     * 
     * @param time The time string in 12-hour format (e.g., "6PM", "10AM")
     * @return The hour in 24-hour format
     */
    private int convertTo24Hour(String time) {
        int hour = Integer.parseInt(time.replaceAll("[^0-9]", ""));
        if (time.contains("PM") && hour != 12) {
            hour += 12;
        }
        if (time.contains("AM") && hour == 12) {
            hour = 0;
        }
        return hour;
    }

    /**
     * Prints the student's enrolled courses to the console.
     */
    public void printCourses() {
        if (courses.isEmpty()) {
            System.out.println(name + " is not enrolled in any courses.");
        } else {
            System.out.println(name + "'s Courses:");
            for (String course : courses) {
                System.out.println(" - " + course);
            }
        }
    }

    /**
     * Prints the student's availability schedule to the console.
     */
    public void printAvailabilities() {
        if (availabilities.isEmpty()) {
            System.out.println(name + " has no availability set.");
        } else {
            System.out.println(name + "'s Availability:");
            for (Availability availability : availabilities) {
                System.out.println(" - " + availability);
            }
        }
    }

    /**
     * Returns a string representation of the student.
     * 
     * @return A formatted string containing the student's details
     */
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", courses=" + courses +
                ", availability=" + availabilities +
                '}';
    }
}

