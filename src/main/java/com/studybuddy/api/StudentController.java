package com.studybuddy.api;

import com.studybuddy.dto.StudentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * REST API Controller for Student operations.
 * Provides endpoints for managing students in the StudyBuddy application.
 * 
 * @author StudyBuddy Team
 * @version 1.0
 */
@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    // In-memory storage for demonstration (replace with database in production)
    private final List<StudentDTO> students = new ArrayList<>();
    private Long nextId = 1L;

    /**
     * GET /api/students - Get all students
     */
    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return ResponseEntity.ok(students);
    }

    /**
     * GET /api/students/{id} - Get student by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * POST /api/students - Create a new student
     */
    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO) {
        studentDTO.setId(nextId++);
        if (studentDTO.getCourses() == null) {
            studentDTO.setCourses(new ArrayList<>());
        }
        if (studentDTO.getAvailabilities() == null) {
            studentDTO.setAvailabilities(new ArrayList<>());
        }
        students.add(studentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentDTO);
    }

    /**
     * PUT /api/students/{id} - Update an existing student
     */
    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                studentDTO.setId(id);
                students.set(i, studentDTO);
                return ResponseEntity.ok(studentDTO);
            }
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * DELETE /api/students/{id} - Delete a student
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        boolean removed = students.removeIf(s -> s.getId().equals(id));
        return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    /**
     * GET /api/students/search?major={major} - Search students by major
     */
    @GetMapping("/search")
    public ResponseEntity<List<StudentDTO>> searchStudentsByMajor(@RequestParam String major) {
        List<StudentDTO> result = new ArrayList<>();
        for (StudentDTO student : students) {
            if (student.getMajor().equalsIgnoreCase(major)) {
                result.add(student);
            }
        }
        return ResponseEntity.ok(result);
    }
}
