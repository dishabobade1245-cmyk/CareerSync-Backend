package com.careersync.careersyncbackend.service;

import com.careersync.careersyncbackend.dto.JobRequest;
import com.careersync.careersyncbackend.entity.Job;
import com.careersync.careersyncbackend.entity.User;
import com.careersync.careersyncbackend.repository.JobRepository;
import com.careersync.careersyncbackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private final JobRepository jobRepository;
    private final UserRepository userRepository;

    public JobService(
            JobRepository jobRepository,
            UserRepository userRepository) {

        this.jobRepository = jobRepository;
        this.userRepository = userRepository;
    }

    public Job createJob(String email, JobRequest request) {

        User recruiter = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("Recruiter not found"));

        Job job = new Job();

        job.setTitle(request.getTitle());
        job.setCompany(request.getCompany());
        job.setDescription(request.getDescription());
        job.setLocation(request.getLocation());
        job.setEmploymentType(request.getEmploymentType());
        job.setSalary(request.getSalary());
        job.setRequiredSkills(request.getRequiredSkills());
        job.setRecruiter(recruiter);

        return jobRepository.save(job);
    }

    public List<Job> getRecruiterJobs(String email) {

        User recruiter = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("Recruiter not found"));

        return jobRepository.findByRecruiterId(recruiter.getId());
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
}