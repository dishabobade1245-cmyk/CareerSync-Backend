package com.careersync.careersyncbackend.service;

import com.careersync.careersyncbackend.entity.ApplicationStatus;
import com.careersync.careersyncbackend.entity.Job;
import com.careersync.careersyncbackend.entity.JobApplication;
import com.careersync.careersyncbackend.entity.User;
import com.careersync.careersyncbackend.repository.JobApplicationRepository;
import com.careersync.careersyncbackend.repository.JobRepository;
import com.careersync.careersyncbackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;
    private final JobRepository jobRepository;
    private final UserRepository userRepository;

    public JobApplicationService(
            JobApplicationRepository jobApplicationRepository,
            JobRepository jobRepository,
            UserRepository userRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
        this.jobRepository = jobRepository;
        this.userRepository = userRepository;
    }

    public JobApplication applyForJob(
            String email,
            Long jobId) {

        User student = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        if (jobApplicationRepository
                .findByJobIdAndStudentId(jobId, student.getId())
                .isPresent()) {
            throw new RuntimeException("Already applied for this job");
        }

        JobApplication application = new JobApplication();
        application.setJob(job);
        application.setStudent(student);
        application.setStatus(ApplicationStatus.APPLIED);

        return jobApplicationRepository.save(application);
    }

    public List<JobApplication> getStudentApplications(
            String email) {

        User student = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return jobApplicationRepository
                .findByStudentId(student.getId());
    }

    public List<JobApplication> getRecruiterApplications(
            String email) {

        User recruiter = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Recruiter not found"));

        return jobApplicationRepository
                .findByJobRecruiterId(recruiter.getId());
    }

    public JobApplication updateApplicationStatus(
            String email,
            Long applicationId,
            ApplicationStatus status) {

        User recruiter = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Recruiter not found"));

        JobApplication application =
                jobApplicationRepository.findById(applicationId)
                        .orElseThrow(() ->
                                new RuntimeException("Application not found"));

        if (!application.getJob().getRecruiter().getId()
                .equals(recruiter.getId())) {
            throw new RuntimeException(
                    "You are not authorized to update this application"
            );
        }

        application.setStatus(status);

        return jobApplicationRepository.save(application);
    }
}