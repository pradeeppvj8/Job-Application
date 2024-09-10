package com.pradeep.job_application.job.repository;

import com.pradeep.job_application.job.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
