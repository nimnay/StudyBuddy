package models;
import java.util.ArrayList;
import java.util.List;


public class Student {
    // Student.java

    private String name;
    private List<Availability> availabilities;

    public Student(String name) {
        this.name = name;
        this.availabilities = new ArrayList<>();
    }

    public String getName() {
            return name;
    }

    public List<Availability> getAvailabilities() {
        return availabilities;
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
}

