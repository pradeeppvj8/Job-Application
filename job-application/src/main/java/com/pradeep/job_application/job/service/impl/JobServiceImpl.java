package com.pradeep.job_application.job.service.impl;

import com.pradeep.job_application.job.exception.JobNotFoundException;
import com.pradeep.job_application.job.model.Job;
import com.pradeep.job_application.job.service.interfaces.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
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

    @Override
    public boolean deleteJobById(Long id) {
        Iterator<Job> jobIterator = jobs.iterator();

        while (jobIterator.hasNext()) {
            Job job = jobIterator.next();

            if (job.getId().equals(id)) {
                jobIterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateJobById(Long id, Job updatedJob) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setLocation(updatedJob.getLocation());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                return true;
            }
        }
        return false;
    }
}
