package com.example.Anoop_Springboot_Study.domain;

import javax.persistence.*;

@Entity
@Table(name = "family")
public class DomainFamilyMembers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Age")
    private long age;

    @Column(name = "Job")
    private String job;

    public DomainFamilyMembers() {
    }

    public DomainFamilyMembers(String name, long age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
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

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
