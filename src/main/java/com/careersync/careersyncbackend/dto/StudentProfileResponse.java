package com.careersync.careersyncbackend.dto;

public class StudentProfileResponse {

    private Long id;
    private String phone;
    private String college;
    private String branch;
    private Integer graduationYear;
    private Double cgpa;
    private String skills;
    private String resumeUrl;

    public StudentProfileResponse(
            Long id,
            String phone,
            String college,
            String branch,
            Integer graduationYear,
            Double cgpa,
            String skills,
            String resumeUrl) {

        this.id = id;
        this.phone = phone;
        this.college = college;
        this.branch = branch;
        this.graduationYear = graduationYear;
        this.cgpa = cgpa;
        this.skills = skills;
        this.resumeUrl = resumeUrl;
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
}