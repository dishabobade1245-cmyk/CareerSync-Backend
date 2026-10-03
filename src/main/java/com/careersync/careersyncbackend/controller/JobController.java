package com.careersync.careersyncbackend.controller;

import com.careersync.careersyncbackend.dto.JobRequest;
import com.careersync.careersyncbackend.dto.JobResponse;
import com.careersync.careersyncbackend.entity.Job;
import com.careersync.careersyncbackend.service.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping("/recruiter/jobs")
    public ResponseEntity<JobResponse> createJob(
            @RequestBody JobRequest request,
            Authentication authentication) {

        Job job = jobService.createJob(
                authentication.getName(),
                request
        );

        return ResponseEntity.ok(toResponse(job));
    }

    @GetMapping("/recruiter/jobs")
    public ResponseEntity<List<JobResponse>> getRecruiterJobs(
            Authentication authentication) {

        List<Job> jobs =
                jobService.getRecruiterJobs(authentication.getName());

        return ResponseEntity.ok(
                jobs.stream()
                        .map(this::toResponse)
                        .toList()
        );
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<JobResponse>> getAllJobs() {

        List<Job> jobs = jobService.getAllJobs();

        return ResponseEntity.ok(
                jobs.stream()
                        .map(this::toResponse)
                        .toList()
        );
    }

    private JobResponse toResponse(Job job) {

        return new JobResponse(
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
        );
    }
}