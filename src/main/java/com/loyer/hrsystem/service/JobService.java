package com.loyer.hrsystem.service;

import com.loyer.hrsystem.model.App;
import com.loyer.hrsystem.model.Job;
import com.loyer.hrsystem.model.JobAddForm;

import java.util.List;
import java.util.Map;

public interface JobService {
    void addJob(JobAddForm form);
    Iterable<Job> getJobs();
    void deleteJobById(long id);
    Job getJobDetailsById(long id);
}
