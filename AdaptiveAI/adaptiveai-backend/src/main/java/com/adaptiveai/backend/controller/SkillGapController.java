package com.adaptiveai.backend.controller;

import com.adaptiveai.backend.model.SkillScore;
import com.adaptiveai.backend.repository.SkillScoreRepository;
import com.adaptiveai.backend.service.SkillGapService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/skill-gaps")
public class SkillGapController {

    private final SkillScoreRepository repository;
    private final SkillGapService service;

    public SkillGapController(
            SkillScoreRepository repository,
            SkillGapService service) {
        this.repository = repository;
        this.service = service;
    }

    @PostMapping("/{studentId}")
    public List<Map<String, Object>> analyze(
            @PathVariable Long studentId,
            @RequestBody List<SkillScore> skills) {

        skills.forEach(skill -> skill.setStudentId(studentId));

        repository.saveAll(skills);

        return service.analyze(skills);
    }

    @GetMapping("/{studentId}")
    public List<Map<String, Object>> getGaps(
            @PathVariable Long studentId) {

        return service.analyze(
                repository.findByStudentId(studentId)
        );
    }
}