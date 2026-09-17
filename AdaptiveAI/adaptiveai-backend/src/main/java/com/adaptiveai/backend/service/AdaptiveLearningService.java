package com.adaptiveai.backend.service;

import com.adaptiveai.backend.model.LearningPath;
import com.adaptiveai.backend.model.SkillScore;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AdaptiveLearningService {

    public List<LearningPath> generate(List<SkillScore> skills) {

        List<LearningPath> path = new ArrayList<>();

        skills.sort(
                Comparator.comparingInt(SkillScore::getScore)
        );

        for (SkillScore skill : skills) {

            String difficulty;

            if (skill.getScore() < 40) {
                difficulty = "Beginner";
            } else if (skill.getScore() < 70) {
                difficulty = "Intermediate";
            } else {
                difficulty = "Advanced";
            }

            String topic = skill.getSkillName() + " Fundamentals";

            path.add(
                    new LearningPath(
                            skill.getSkillName(),
                            topic,
                            difficulty,
                            45,
                            path.isEmpty() ? "CURRENT" : "UPCOMING"
                    )
            );
        }

        return path;
    }
}