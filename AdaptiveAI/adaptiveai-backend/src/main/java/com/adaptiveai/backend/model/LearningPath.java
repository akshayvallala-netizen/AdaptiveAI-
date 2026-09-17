package com.adaptiveai.backend.model;

public class LearningPath {

    private String skill;
    private String topic;
    private String difficulty;
    private int duration;
    private String status;

    public LearningPath(
            String skill,
            String topic,
            String difficulty,
            int duration,
            String status) {

        this.skill = skill;
        this.topic = topic;
        this.difficulty = difficulty;
        this.duration = duration;
        this.status = status;
    }

    public String getSkill() {
        return skill;
    }

    public String getTopic() {
        return topic;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public int getDuration() {
        return duration;
    }

    public String getStatus() {
        return status;
    }
}