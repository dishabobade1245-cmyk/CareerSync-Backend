package com.careersync.careersyncbackend.controller;

import com.careersync.careersyncbackend.dto.StudentProfileRequest;
import com.careersync.careersyncbackend.dto.StudentProfileResponse;
import com.careersync.careersyncbackend.entity.StudentProfile;
import com.careersync.careersyncbackend.service.StudentProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student/profile")
public class StudentProfileController {

    private final StudentProfileService studentProfileService;

    public StudentProfileController(
            StudentProfileService studentProfileService) {

        this.studentProfileService = studentProfileService;
    }

    @PostMapping
    public ResponseEntity<StudentProfileResponse> createProfile(
            @RequestBody StudentProfileRequest request,
            Authentication authentication) {

        StudentProfile profile =
                studentProfileService.createProfile(
                        authentication.getName(),
                        request.getPhone(),
                        request.getCollege(),
                        request.getBranch(),
                        request.getGraduationYear(),
                        request.getCgpa(),
                        request.getSkills(),
                        request.getResumeUrl()
                );

        return ResponseEntity.ok(toResponse(profile));
    }

    @GetMapping
    public ResponseEntity<StudentProfileResponse> getProfile(
            Authentication authentication) {

        StudentProfile profile =
                studentProfileService.getProfile(
                        authentication.getName()
                );

        return ResponseEntity.ok(toResponse(profile));
    }

    private StudentProfileResponse toResponse(StudentProfile profile) {

        return new StudentProfileResponse(
                profile.getId(),
                profile.getPhone(),
                profile.getCollege(),
                profile.getBranch(),
                profile.getGraduationYear(),
                profile.getCgpa(),
                profile.getSkills(),
                profile.getResumeUrl()
        );
    }
}