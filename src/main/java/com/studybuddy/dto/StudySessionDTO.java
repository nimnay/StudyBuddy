package com.studybuddy.dto;

import java.util.List;

/**
 * Data Transfer Object for Study Session information.
 */
public class StudySessionDTO {
    private Long id;
    private String course;
    private String time;
    private StudentDTO creator;
    private List<StudentDTO> participants;

    public StudySessionDTO() {
    }

    public StudySessionDTO(String course, String time) {
        this.course = course;
        this.time = time;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public StudentDTO getCreator() {
        return creator;
    }

    public void setCreator(StudentDTO creator) {
        this.creator = creator;
    }

    public List<StudentDTO> getParticipants() {
        return participants;
    }

    public void setParticipants(List<StudentDTO> participants) {
        this.participants = participants;
    }
}
