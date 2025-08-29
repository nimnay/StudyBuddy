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
            System.out.println("Added course: " + course);
        } else {
            System.out.println("That course is already enrolled.");
        }
    }

    public void removeCourse(String course) {
        if (courses.remove(course)) {
            System.out.println("Removed course: " + course);
        } else {
            System.out.println("Course not found.");
        }
    }

        // Story 2.1 - Add availability
    public void addAvailability(String dayOfWeek, String timeSlot) {
        Availability newSlot = new Availability(dayOfWeek, timeSlot);
        if (!availabilities.contains(newSlot)) {
            availabilities.add(newSlot);
            System.out.println("Added availability: " + newSlot);
        } else {
            System.out.println("That availability already exists.");
        }
    }

    // Story 2.2 - Remove availability
    public void removeAvailability(String dayOfWeek, String timeSlot) {
        Availability slotToRemove = new Availability(dayOfWeek, timeSlot);
        if (availabilities.remove(slotToRemove)) {
            System.out.println("Removed availability: " + slotToRemove);
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
    public boolean isFreeAt(String dayOfWeek, String timeSlot) {
        Availability check = new Availability(dayOfWeek, timeSlot);
        return availabilities.contains(check);
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

