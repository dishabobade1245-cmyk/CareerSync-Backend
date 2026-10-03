package com.careersync.careersyncbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(
    name = "job_applications",
    uniqueConstraints = {
        @UniqueConstraint(
            columnNames = {"job_id", "student_id"}
        )
    }
)
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private User student;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ApplicationStatus status;

    public JobApplication() {
    }

    public JobApplication(
            Long id,
            Job job,
            User student,
            ApplicationStatus status) {
        this.id = id;
        this.job = job;
        this.student = student;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Job getJob() {
        return job;
    }

    public User getStudent() {
        return student;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }
}