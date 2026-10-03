package com.careersync.careersyncbackend.controller;

import com.careersync.careersyncbackend.dto.JobApplicationResponse;
import com.careersync.careersyncbackend.dto.JobResponse;
import com.careersync.careersyncbackend.dto.UserResponse;
import com.careersync.careersyncbackend.entity.Job;
import com.careersync.careersyncbackend.entity.JobApplication;
import com.careersync.careersyncbackend.entity.User;
import com.careersync.careersyncbackend.repository.JobApplicationRepository;
import com.careersync.careersyncbackend.repository.JobRepository;
import com.careersync.careersyncbackend.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final UserRepository userRepository;
    private final JobRepository jobRepository;
    private final JobApplicationRepository jobApplicationRepository;

    public AdminController(
            UserRepository userRepository,
            JobRepository jobRepository,
            JobApplicationRepository jobApplicationRepository) {

        this.userRepository = userRepository;
        this.jobRepository = jobRepository;
        this.jobApplicationRepository = jobApplicationRepository;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getAllUsers() {

        List<User> users = userRepository.findAll();

        return ResponseEntity.ok(
                users.stream()
                        .map(user -> new UserResponse(
                                user.getId(),
                                user.getName(),
                                user.getEmail(),
                                user.getRole().name()
                        ))
                        .toList()
        );
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<JobResponse>> getAllJobs() {

        List<Job> jobs = jobRepository.findAll();

        return ResponseEntity.ok(
                jobs.stream()
                        .map(job -> new JobResponse(
                                job.getId(),
                                job.getTitle(),
                                job.getCompany(),
                                job.getDescription(),
                                job.getLocation(),
                                job.getEmploymentType(),
                                job.getSalary(),
                                job.getRequiredSkills(),
                                job.getRecruiter().getId(),
                                job.getRecruiter().getName()
                        ))
                        .toList()
        );
    }

    @GetMapping("/applications")
    public ResponseEntity<List<JobApplicationResponse>> getAllApplications() {

        List<JobApplication> applications =
                jobApplicationRepository.findAll();

        return ResponseEntity.ok(
                applications.stream()
                        .map(application -> new JobApplicationResponse(
                                application.getId(),
                                application.getJob().getId(),
                                application.getJob().getTitle(),
                                application.getJob().getCompany(),
                                application.getStudent().getId(),
                                application.getStudent().getName(),
                                application.getStatus().name()
                        ))
                        .toList()
        );
    }
}