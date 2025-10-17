package com.studybuddy.api;

import com.studybuddy.dto.StudySessionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * REST API Controller for Study Session operations.
 * Provides endpoints for managing study sessions in the StudyBuddy application.
 * 
 * @author StudyBuddy Team
 * @version 1.0
 */
@RestController
@RequestMapping("/api/sessions")
@CrossOrigin(origins = "*")
public class SessionController {

    // In-memory storage for demonstration (replace with database in production)
    private final List<StudySessionDTO> sessions = new ArrayList<>();
    private Long nextId = 1L;

    /**
     * GET /api/sessions - Get all study sessions
     */
    @GetMapping
    public ResponseEntity<List<StudySessionDTO>> getAllSessions() {
        return ResponseEntity.ok(sessions);
    }

    /**
     * GET /api/sessions/{id} - Get session by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<StudySessionDTO> getSessionById(@PathVariable Long id) {
        return sessions.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * POST /api/sessions - Create a new study session
     */
    @PostMapping
    public ResponseEntity<StudySessionDTO> createSession(@RequestBody StudySessionDTO sessionDTO) {
        sessionDTO.setId(nextId++);
        if (sessionDTO.getParticipants() == null) {
            sessionDTO.setParticipants(new ArrayList<>());
        }
        sessions.add(sessionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(sessionDTO);
    }

    /**
     * PUT /api/sessions/{id} - Update an existing session
     */
    @PutMapping("/{id}")
    public ResponseEntity<StudySessionDTO> updateSession(@PathVariable Long id, @RequestBody StudySessionDTO sessionDTO) {
        for (int i = 0; i < sessions.size(); i++) {
            if (sessions.get(i).getId().equals(id)) {
                sessionDTO.setId(id);
                sessions.set(i, sessionDTO);
                return ResponseEntity.ok(sessionDTO);
            }
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * DELETE /api/sessions/{id} - Delete a session
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSession(@PathVariable Long id) {
        boolean removed = sessions.removeIf(s -> s.getId().equals(id));
        return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    /**
     * GET /api/sessions/search?course={course} - Search sessions by course
     */
    @GetMapping("/search")
    public ResponseEntity<List<StudySessionDTO>> searchSessionsByCourse(@RequestParam String course) {
        List<StudySessionDTO> result = new ArrayList<>();
        for (StudySessionDTO session : sessions) {
            if (session.getCourse().equalsIgnoreCase(course)) {
                result.add(session);
            }
        }
        return ResponseEntity.ok(result);
    }
}
