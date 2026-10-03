package com.careersync.careersyncbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String company;

    @Column(nullable = false, length = 2000)
    private String description;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String employmentType;

    private Double salary;

    private String requiredSkills;

    @ManyToOne
    @JoinColumn(name = "recruiter_id", nullable = false)
    private User recruiter;

    public Job() {
    }

    public Job(Long id,
               String title,
               String company,
               String description,
               String location,
               String employmentType,
               Double salary,
               String requiredSkills,
               User recruiter) {

        this.id = id;
        this.title = title;
        this.company = company;
        this.description = description;
        this.location = location;
        this.employmentType = employmentType;
        this.salary = salary;
        this.requiredSkills = requiredSkills;
        this.recruiter = recruiter;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public Double getSalary() {
        return salary;
    }

    public String getRequiredSkills() {
        return requiredSkills;
    }

    public User getRecruiter() {
        return recruiter;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setRequiredSkills(String requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public void setRecruiter(User recruiter) {
        this.recruiter = recruiter;
    }
}