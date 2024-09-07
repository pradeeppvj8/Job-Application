package com.pradeep.job_application.job.service.impl;

import com.pradeep.job_application.job.exception.JobNotFoundException;
import com.pradeep.job_application.job.model.Job;
import com.pradeep.job_application.job.service.interfaces.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobs = new ArrayList<>();

    @Override
    public List<Job> fetchAllJobs() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        jobs.add(job);
    }

    @Override
    public Job findJobById(Long id) {
        return jobs.stream()
                .filter(job -> job.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new JobNotFoundException("Job with ID - " + id + " not found"));
    }
}
