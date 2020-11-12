package com.example.Anoop_Springboot_Study.domain;

import javax.persistence.*;

@Entity
public class DomainFamilyMembers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Age")
    private String age;

    @Column(name = "Job")
    private String job;

    public DomainFamilyMembers(String name, String age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public DomainFamilyMembers() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
