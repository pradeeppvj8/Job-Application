package com.pradeep.job_application.job.controller;

import com.pradeep.job_application.job.model.Job;
import com.pradeep.job_application.job.service.interfaces.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/job")
public class JobController {
    private final JobService jobService;
    private Long nextId = 1L;

    @GetMapping("/all")
    public List<Job> fetchAllJobs() {
        return jobService.fetchAllJobs();
    }

    @PostMapping("/create-job")
    public String createJob(@RequestBody Job job) {
        job.setId(nextId++);
        jobService.createJob(job);
        return "Job created successfully";
    }

    @GetMapping("/find-job/{id}")
    public Job findJobById(@PathVariable Long id) {
        return jobService.findJobById(id);
    }
}
