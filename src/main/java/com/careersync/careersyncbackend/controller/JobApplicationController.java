package com.careersync.careersyncbackend.controller;

import com.careersync.careersyncbackend.dto.JobApplicationResponse;
import com.careersync.careersyncbackend.entity.ApplicationStatus;
import com.careersync.careersyncbackend.entity.JobApplication;
import com.careersync.careersyncbackend.service.JobApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    public JobApplicationController(
            JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    @PostMapping("/student/jobs/{jobId}/apply")
    public ResponseEntity<JobApplicationResponse> applyForJob(
            @PathVariable Long jobId,
            Authentication authentication) {

        JobApplication application =
                jobApplicationService.applyForJob(
                        authentication.getName(),
                        jobId
                );

        return ResponseEntity.ok(toResponse(application));
    }

    @GetMapping("/student/applications")
    public ResponseEntity<List<JobApplicationResponse>> getStudentApplications(
            Authentication authentication) {

        List<JobApplication> applications =
                jobApplicationService.getStudentApplications(
                        authentication.getName()
                );

        return ResponseEntity.ok(
                applications.stream()
                        .map(this::toResponse)
                        .toList()
        );
    }

    @GetMapping("/recruiter/applications")
    public ResponseEntity<List<JobApplicationResponse>> getRecruiterApplications(
            Authentication authentication) {

        List<JobApplication> applications =
                jobApplicationService.getRecruiterApplications(
                        authentication.getName()
                );

        return ResponseEntity.ok(
                applications.stream()
                        .map(this::toResponse)
                        .toList()
        );
    }

    @PutMapping("/recruiter/applications/{applicationId}/status")
    public ResponseEntity<JobApplicationResponse> updateApplicationStatus(
            @PathVariable Long applicationId,
            @RequestParam ApplicationStatus status,
            Authentication authentication) {

        JobApplication application =
                jobApplicationService.updateApplicationStatus(
                        authentication.getName(),
                        applicationId,
                        status
                );

        return ResponseEntity.ok(toResponse(application));
    }

    private JobApplicationResponse toResponse(
            JobApplication application) {

        return new JobApplicationResponse(
                application.getId(),
                application.getJob().getId(),
                application.getJob().getTitle(),
                application.getJob().getCompany(),
                application.getStudent().getId(),
                application.getStudent().getName(),
                application.getStatus().name()
        );
    }
}