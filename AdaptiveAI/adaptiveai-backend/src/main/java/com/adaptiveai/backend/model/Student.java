package com.adaptiveai.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    private String id;

    private String name;
    private String goal;
    private String experience;
    private int availableTime;
    private String password;

    public Student() {
    }

    public Student(String id, String name, String goal,
                   String experience, int availableTime, String password) {
        this.id = id;
        this.name = name;
        this.goal = goal;
        this.experience = experience;
        this.availableTime = availableTime;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public int getAvailableTime() {
        return availableTime;
    }

    public void setAvailableTime(int availableTime) {
        this.availableTime = availableTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}