package com.careersync.careersyncbackend.repository;

import com.careersync.careersyncbackend.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JobApplicationRepository
        extends JpaRepository<JobApplication, Long> {

    Optional<JobApplication> findByJobIdAndStudentId(
            Long jobId,
            Long studentId
    );

    List<JobApplication> findByStudentId(Long studentId);

    List<JobApplication> findByJobRecruiterId(Long recruiterId);
}