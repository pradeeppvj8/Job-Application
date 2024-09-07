package com.pradeep.job_application.job.service.interfaces;

import com.pradeep.job_application.job.model.Job;

import java.util.List;

public interface JobService {
    List<Job> fetchAllJobs();

    void createJob(Job job);

    Job findJobById(Long id);
}
