package com.loyer.hrsystem.service;

import com.loyer.hrsystem.model.App;
import com.loyer.hrsystem.model.Job;
import com.loyer.hrsystem.model.JobAddForm;
import com.loyer.hrsystem.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    //tüm job nesnelerini çekiyoruz.
    @Override
    public Iterable<Job> getJobs() {
        return jobRepository.findAll();
    }

    //idye göre repositroyden job siliyoruz.
    @Override
    public void deleteJobById(long id) {
        jobRepository.delete(id);
    }

    //job detaylarını çekiyoruz
    @Override
    public Job getJobDetailsById(long id) {
        Job job = jobRepository.findOne(id);
        System.out.println(job);
        return job;
    }

    @Override
    public Job getJobById(long id) {
        return jobRepository.findOne(id);
    }

    //idye göre iş ilanına olan başvuruları listeliyoruz.
    @Override
    public Map<String, List<App>> getAppsById(long jobId) {
        Map<String, List<App>> map = new HashMap<>();
        Set<App> apps = getJobById(jobId).getApps();

        for(App app: apps) {
            List<App> appList = new ArrayList<>();
            String key = ""+ app.getId();
            if(map.containsKey(key))
                appList = map.get(key);

            appList.add(app);
            map.put(key,appList);
        }
        return map;
    }
}
