package com.adaptiveai.backend.repository;

import com.adaptiveai.backend.model.SkillScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillScoreRepository
        extends JpaRepository<SkillScore, Long> {

    List<SkillScore> findByStudentId(Long studentId);
}