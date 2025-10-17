package com.studybuddy.dto;

import java.util.List;

/**
 * Data Transfer Object for Student information.
 * Used for API requests and responses.
 */
public class StudentDTO {
    private Long id;
    private String name;
    private String major;
    private List<String> courses;
    private List<AvailabilityDTO> availabilities;

    public StudentDTO() {
    }

    public StudentDTO(String name, String major) {
        this.name = name;
        this.major = major;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public List<AvailabilityDTO> getAvailabilities() {
        return availabilities;
    }

    public void setAvailabilities(List<AvailabilityDTO> availabilities) {
        this.availabilities = availabilities;
    }
}
