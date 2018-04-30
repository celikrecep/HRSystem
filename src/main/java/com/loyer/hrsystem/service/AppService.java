package com.loyer.hrsystem.service;

import com.loyer.hrsystem.model.App;
import com.loyer.hrsystem.model.AppAddForm;



public interface AppService {
    void addApp(AppAddForm form);
    App applyApp(long jobId);
    Iterable<App> getApps();
    App getApById(long id);
}
