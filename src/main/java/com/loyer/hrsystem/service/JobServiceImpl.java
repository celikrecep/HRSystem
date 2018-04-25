package com.loyer.hrsystem.service;

import com.loyer.hrsystem.model.Job;
import com.loyer.hrsystem.model.JobAddForm;
import com.loyer.hrsystem.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    @Autowired
    public JobServiceImpl(JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }

    @Override
    public void addJob(JobAddForm form) {

        Job job = new Job(form.getJobTitle(), form.getDescription(), form.getNumbHirePeople(), form.getLastAppDate());
        jobRepository.save(job);
        System.out.println(jobRepository.findOne(job.getId()));
    }
}
