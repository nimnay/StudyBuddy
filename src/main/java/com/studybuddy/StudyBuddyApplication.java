package com.studybuddy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the StudyBuddy Spring Boot application.
 * Provides REST API endpoints for frontend integration.
 * 
 * @author StudyBuddy Team
 * @version 1.0
 */
@SpringBootApplication
public class StudyBuddyApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(StudyBuddyApplication.class, args);
    }
}
