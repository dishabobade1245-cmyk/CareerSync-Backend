package com.careersync.careersyncbackend.service;

import com.careersync.careersyncbackend.entity.StudentProfile;
import com.careersync.careersyncbackend.entity.User;
import com.careersync.careersyncbackend.repository.StudentProfileRepository;
import com.careersync.careersyncbackend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentProfileService {

    private final StudentProfileRepository studentProfileRepository;
    private final UserRepository userRepository;

    public StudentProfileService(
            StudentProfileRepository studentProfileRepository,
            UserRepository userRepository) {

        this.studentProfileRepository = studentProfileRepository;
        this.userRepository = userRepository;
    }

    public StudentProfile createProfile(
            String email,
            String phone,
            String college,
            String branch,
            Integer graduationYear,
            Double cgpa,
            String skills,
            String resumeUrl) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        if (studentProfileRepository.findByUserId(user.getId()).isPresent()) {
            throw new RuntimeException("Student profile already exists");
        }

        StudentProfile profile = new StudentProfile();

        profile.setPhone(phone);
        profile.setCollege(college);
        profile.setBranch(branch);
        profile.setGraduationYear(graduationYear);
        profile.setCgpa(cgpa);
        profile.setSkills(skills);
        profile.setResumeUrl(resumeUrl);
        profile.setUser(user);

        return studentProfileRepository.save(profile);
    }

    public StudentProfile getProfile(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        return studentProfileRepository.findByUserId(user.getId())
                .orElseThrow(() ->
                        new RuntimeException("Student profile not found"));
    }
}