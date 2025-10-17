package com.studybuddy.dto;

/**
 * Data Transfer Object for Availability information.
 */
public class AvailabilityDTO {
    private String dayOfWeek;
    private String timeSlot;

    public AvailabilityDTO() {
    }

    public AvailabilityDTO(String dayOfWeek, String timeSlot) {
        this.dayOfWeek = dayOfWeek;
        this.timeSlot = timeSlot;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }
}
