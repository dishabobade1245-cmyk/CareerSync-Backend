package com.careersync.careersyncbackend.dto;

public class JobResponse {

    private Long id;
    private String title;
    private String company;
    private String description;
    private String location;
    private String employmentType;
    private Double salary;
    private String requiredSkills;
    private Long recruiterId;
    private String recruiterName;

    public JobResponse(
            Long id,
            String title,
            String company,
            String description,
            String location,
            String employmentType,
            Double salary,
            String requiredSkills,
            Long recruiterId,
            String recruiterName) {

        this.id = id;
        this.title = title;
        this.company = company;
        this.description = description;
        this.location = location;
        this.employmentType = employmentType;
        this.salary = salary;
        this.requiredSkills = requiredSkills;
        this.recruiterId = recruiterId;
        this.recruiterName = recruiterName;
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

    public Long getRecruiterId() {
        return recruiterId;
    }

    public String getRecruiterName() {
        return recruiterName;
    }
}