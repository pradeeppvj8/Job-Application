package com.pradeep.job_application.job.controller;

import com.pradeep.job_application.job.exception.JobNotFoundException;
import com.pradeep.job_application.job.model.Job;
import com.pradeep.job_application.job.service.interfaces.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jobs")
public class JobController {
    private final JobService jobService;
    private Long nextId = 1L;

    @GetMapping("/all")
    public ResponseEntity<List<Job>> fetchAllJobs() {
        return ResponseEntity.ok(jobService.fetchAllJobs());
    }

    @PostMapping("/create-job")
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        job.setId(nextId++);
        jobService.createJob(job);
        return ResponseEntity.ok("Job created successfully");
    }

    @GetMapping("/find-job/{id}")
    public ResponseEntity<?> findJobById(@PathVariable Long id) {
        try {
            Job job = jobService.findJobById(id);
            return ResponseEntity.ok(job);
        } catch (JobNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete-job/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id) {
        boolean isDeleted = jobService.deleteJobById(id);

        if (isDeleted) {
            return ResponseEntity.ok("Job deleted successfully");
        }
        return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update-job/{id}")
    public ResponseEntity<String> updateJobById(@PathVariable Long id, @RequestBody Job updatedJob) {
        boolean isUpdated = jobService.updateJobById(id, updatedJob);

        if (isUpdated) {
            return ResponseEntity.ok("Job updated successfully");
        }
        return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND);
    }
}
