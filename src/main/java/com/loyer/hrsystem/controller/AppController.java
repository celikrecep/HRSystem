package com.loyer.hrsystem.controller;

import com.loyer.hrsystem.model.AppAddForm;
import com.loyer.hrsystem.model.Job;
import com.loyer.hrsystem.repository.JobRepository;
import com.loyer.hrsystem.service.AppService;
import com.loyer.hrsystem.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
public class AppController {

    private final AppService appService;
    private final JobService jobService;
    private final JobRepository jobRepository;
    private Job job;

    @Autowired
    public AppController(AppService appService, JobService jobService,JobRepository jobRepository) {
        this.jobService = jobService;
        this.appService = appService;
        this.jobRepository = jobRepository;
    }

    //başvuru kaydediyoruz
    @RequestMapping(value = "/apps", method = RequestMethod.POST)
    public String handleAppAdd(@Valid @ModelAttribute("appForm") AppAddForm appAddForm, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "addApp";

        appService.addApp(appAddForm);
        appService.applyApp(job.getId());


        return "redirect:/jobs/";
    }
    //addApp viewına birden fazla model göndermek için map kullandık.
    //parametre olarakta id alıp ilgili job nesnesinin detaylarını çekicez.
    @RequestMapping("/jobs/{id}/app")
    public ModelAndView getDetailsOnAppFormPage(@PathVariable Long id, ModelMap map){

        map.addAttribute("jobs", jobService.getJobDetailsById(id));
        map.addAttribute("appForm", new AppAddForm());
        job = getJob(id);
        return new ModelAndView("addApp", map);
    }

    //idye göre başvuru detay sayfasını açar
    @RequestMapping("/allapps/{id}/app")
    public ModelAndView getAppDetailsPage(@PathVariable Long id) {
        return new ModelAndView("appDetails","apps",appService.getApById(id));
    }


    //tüm başvurular
        @RequestMapping("/allapps")
    public ModelAndView getAllAppsPage(){
        return new ModelAndView("apps","apps",appService.getApps());
        }


    private Job getJob(long id){
        this.job = jobRepository.findOne(id);
        return job;
    }

}
