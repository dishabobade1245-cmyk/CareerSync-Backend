package com.careersync.careersyncbackend.dto;

public class JobApplicationResponse {

    private Long id;
    private Long jobId;
    private String jobTitle;
    private String company;
    private Long studentId;
    private String studentName;
    private String status;

    public JobApplicationResponse(
            Long id,
            Long jobId,
            String jobTitle,
            String company,
            Long studentId,
            String studentName,
            String status) {

        this.id = id;
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.company = company;
        this.studentId = studentId;
        this.studentName = studentName;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getJobId() {
        return jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getCompany() {
        return company;
    }

    public Long getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStatus() {
        return status;
    }
}