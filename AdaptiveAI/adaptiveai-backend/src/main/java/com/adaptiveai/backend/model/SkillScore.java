package com.adaptiveai.backend.model;

import jakarta.persistence.*;

@Entity
public class SkillScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;
    private String skillName;
    private int score;

    public SkillScore() {
    }

    public SkillScore(Long studentId, String skillName, int score) {
        this.studentId = studentId;
        this.skillName = skillName;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public String getSkillName() {
        return skillName;
    }

    public int getScore() {
        return score;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public void setScore(int score) {
        this.score = score;
    }
}