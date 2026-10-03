package com.careersync.careersyncbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student_profiles")
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phone;

    private String college;

    private String branch;

    private Integer graduationYear;

    private Double cgpa;

    private String skills;

    private String resumeUrl;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    public StudentProfile() {
    }

    public StudentProfile(Long id, String phone, String college,
                           String branch, Integer graduationYear,
                           Double cgpa, String skills,
                           String resumeUrl, User user) {
        this.id = id;
        this.phone = phone;
        this.college = college;
        this.branch = branch;
        this.graduationYear = graduationYear;
        this.cgpa = cgpa;
        this.skills = skills;
        this.resumeUrl = resumeUrl;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getCollege() {
        return college;
    }

    public String getBranch() {
        return branch;
    }

    public Integer getGraduationYear() {
        return graduationYear;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public String getSkills() {
        return skills;
    }

    public String getResumeUrl() {
        return resumeUrl;
    }

    public User getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setGraduationYear(Integer graduationYear) {
        this.graduationYear = graduationYear;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }

    public void setUser(User user) {
        this.user = user;
    }
}