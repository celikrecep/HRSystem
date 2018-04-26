package com.loyer.hrsystem.service;

import com.loyer.hrsystem.model.App;
import com.loyer.hrsystem.model.AppAddForm;
import com.loyer.hrsystem.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Controller ve Model arasında durur ,
 * model objesini alır, yaratır, günceller.
 */
@Service
public class AppServiceImpl implements AppService {
    private final AppRepository appRepository;

    @Autowired
    public AppServiceImpl(AppRepository appRepository) {
        this.appRepository = appRepository;
    }

    //yeni app oluşturup bunu repositorymize kaydettik.
    @Override
    public void addApp(AppAddForm form) {
        App app = new App(form.getName(), form.geteMail(), form.getPhoneNumber(), form.getAddress(), form.getThoughtsJob());
        appRepository.save(app);
        System.out.println(appRepository.findOne(app.getId()));

    }
}
