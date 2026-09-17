package com.adaptiveai.backend.repository;

import com.adaptiveai.backend.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}