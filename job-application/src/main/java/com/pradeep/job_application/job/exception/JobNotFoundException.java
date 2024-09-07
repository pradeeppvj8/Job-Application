package com.pradeep.job_application.job.exception;

public class JobNotFoundException extends RuntimeException {
    public JobNotFoundException(String message) {
        super((message));
    }
}
