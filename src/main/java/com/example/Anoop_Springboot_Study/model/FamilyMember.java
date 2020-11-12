package com.example.Anoop_Springboot_Study.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FamilyMember {

    private Long id;
    @NotNull(message="Name cannot be missing or empty")
    @Size(min=3, message="First name must not be less than 2 characters")
    private String name;
    private String age;
    private String job;

    public FamilyMember(Long id, String name, String age, String job) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public FamilyMember() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
