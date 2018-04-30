package com.loyer.hrsystem.service;

import com.loyer.hrsystem.model.App;
import com.loyer.hrsystem.model.AppAddForm;



public interface AppService {
    void addApp(AppAddForm form);
    App applyApp(long jobId, AppAddForm form);
    Iterable<App> getApps();
    App getApById(long id);
}
