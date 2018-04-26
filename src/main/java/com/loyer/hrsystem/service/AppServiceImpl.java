package com.loyer.hrsystem.service;

import com.loyer.hrsystem.model.App;
import com.loyer.hrsystem.model.AppAddForm;
import com.loyer.hrsystem.model.Job;
import com.loyer.hrsystem.repository.AppRepository;
import com.loyer.hrsystem.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Controller ve Model arasında durur ,
 * model objesini alır, yaratır, günceller.
 */
@Service
public class AppServiceImpl implements AppService {
    private final AppRepository appRepository;
    private final JobRepository jobRepository;
    private App tempApp;
    @Autowired
    public AppServiceImpl(AppRepository appRepository, JobRepository jobRepository) {
        this.appRepository = appRepository;
        this.jobRepository = jobRepository;
    }

    //yeni app oluşturup bunu repositorymize kaydettik.
    @Override
    public void addApp(AppAddForm form) {
        App app = new App(form.getName(), form.geteMail(), form.getPhoneNumber(), form.getAddress(), form.getThoughtsJob());
        this.tempApp = app;
        appRepository.save(app);
        System.out.println(appRepository.findOne(app.getId()));

    }

    @Override
    public App getAppById(long id) {
        return appRepository.findOne(id);
    }

    @Override
    public App applyApp(long jobId, AppAddForm form) {
        Job job = jobRepository.findOne(jobId);
        App app = tempApp;

        Set<App> appList = job.getApps();
        appList.add(app);

        job.setApps(appList);

        app.setJob(job);

        System.out.println(appList.size());
        for (App app2: appList){
            System.out.println(app2.getName());
            System.out.println(app2.getPhoneNumber());
            System.out.println(app2.geteMail());
            System.out.println(app2.getAddress());
        }
        return appRepository.save(app);
    }
}
