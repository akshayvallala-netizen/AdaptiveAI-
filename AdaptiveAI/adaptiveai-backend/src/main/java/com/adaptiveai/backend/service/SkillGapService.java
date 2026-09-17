package com.adaptiveai.backend.service;

import com.adaptiveai.backend.model.SkillScore;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SkillGapService {

    public List<Map<String, Object>> analyze(List<SkillScore> skills) {

        List<Map<String, Object>> result = new ArrayList<>();

        for (SkillScore skill : skills) {

            String priority;

            if (skill.getScore() < 40) {
                priority = "HIGH";
            } else if (skill.getScore() < 70) {
                priority = "MEDIUM";
            } else {
                priority = "LOW";
            }

            Map<String, Object> item = new LinkedHashMap<>();

            item.put("skill", skill.getSkillName());
            item.put("score", skill.getScore());
            item.put("gap", 100 - skill.getScore());
            item.put("priority", priority);

            result.add(item);
        }

        result.sort((a, b) ->
                Integer.compare(
                        (int) b.get("gap"),
                        (int) a.get("gap")
                )
        );

        return result;
    }
}