package com.loyer.hrsystem.service;

import com.loyer.hrsystem.model.App;
import com.loyer.hrsystem.model.AppAddForm;
import com.loyer.hrsystem.model.Job;


public interface AppService {
    void addApp(AppAddForm form);
    App getAppById(long id);
    App applyApp(long jobId, AppAddForm form);
}
