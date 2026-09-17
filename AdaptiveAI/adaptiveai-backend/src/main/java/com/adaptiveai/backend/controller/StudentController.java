package com.adaptiveai.backend.controller;

import com.adaptiveai.backend.model.LoginRequest;
import com.adaptiveai.backend.model.Student;
import com.adaptiveai.backend.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/students")
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return repository.save(student);
    }

    @GetMapping
    public List<Student> getStudents() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/login")
    public Student login(@RequestBody LoginRequest request) {

        Student student = repository.findById(request.getId()).orElse(null);

        if (student != null &&
                student.getPassword().equals(request.getPassword())) {

            return student;
        }

        return null;
    }
}