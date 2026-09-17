package com.adaptiveai.backend.controller;

import com.adaptiveai.backend.model.*;
import com.adaptiveai.backend.repository.SkillScoreRepository;
import com.adaptiveai.backend.service.AdaptiveLearningService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/learning-path")
public class LearningPathController {

    private final SkillScoreRepository repository;
    private final AdaptiveLearningService service;

    public LearningPathController(
            SkillScoreRepository repository,
            AdaptiveLearningService service) {

        this.repository = repository;
        this.service = service;
    }

    @GetMapping("/{studentId}")
    public List<LearningPath> getPath(
            @PathVariable Long studentId) {

        List<SkillScore> skills =
                repository.findByStudentId(studentId);

        return service.generate(skills);
    }
}