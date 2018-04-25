package com.loyer.hrsystem.service;

import com.loyer.hrsystem.model.Job;
import com.loyer.hrsystem.model.JobAddForm;

public interface JobService {
    void addJob(JobAddForm form);
    Iterable<Job> getJobs();
    void deleteJobById(long id);
}
