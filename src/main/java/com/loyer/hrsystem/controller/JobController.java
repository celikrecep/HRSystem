package com.loyer.hrsystem.controller;


import com.loyer.hrsystem.model.JobAddForm;
import com.loyer.hrsystem.repository.UserRepository;
import com.loyer.hrsystem.service.AppService;
import com.loyer.hrsystem.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.NoSuchElementException;

@Controller
public class JobController {

    private final JobService jobService;
    private final UserRepository userRepository;
    private final AppService appService;

    @Autowired
    public JobController(JobService jobService, UserRepository userRepository, AppService appService) {

        this.userRepository = userRepository;
        this.jobService = jobService;
        this.appService = appService;
    }

    //addJob sayfasında kullanacağımız modelimizin ismi jobFrom
    //JobAddForm() burda kullanacağımız modelin kendisi.
    @RequestMapping("/jobs/add")
    public ModelAndView jobAddPage(){
        return new ModelAndView("addJob", "jobForm", new JobAddForm());
    }

    //from validation için @Valid anotasyonunu ve BindingResult parametresini kullanıyoruz
    //herhangi bir sıkıntı yoksa nesnemizi kaydediyoruz.
    @RequestMapping(value = "/jobs", method = RequestMethod.POST)
    public String handleJobAdd(@Valid @ModelAttribute("jobForm") JobAddForm form, BindingResult bindingResult){
        if(bindingResult.hasErrors())
        return "addJob";

        jobService.addJob(form);
        return "redirect:/jobs/";
    }

    //tüm job nesnelerinin görüntüleneceği sayfaya yönlendiriyoruz
    //view olarak jobs model olarakta htmlde kullanacağımız ismi veriyoruz
    //jobService.getJobs() burada kullanacağımız model
    @RequestMapping("/jobs/")
    public ModelAndView getJobsPage() {
        return new ModelAndView("jobs", "jobs", jobService.getJobs());
    }

    //ilgili idye sahip job nesnesini siliyoruz
    @RequestMapping(value = "/jobs/{id}", method = RequestMethod.DELETE)
    public String handleJobDelete(@PathVariable Long id) {

        jobService.deleteJobById(id);
        return "redirect:/jobs/";
    }
    //idye göre iş ilanındaki tüm başvuruları getiriyoruz
   @RequestMapping(value = "/jobs/{id}/getApps")
    public ModelAndView getJobsAppPage(@PathVariable Long id){
        if(null == jobService.getJobById(id))
            throw new NoSuchElementException("Job with id:" + id + " not found");
        else
            return new ModelAndView("jobApps","jobs",jobService.getAppsById(id));
   }
    //job nesnesine ait başvurulardan da başvuru detayını görebilmek için
    @RequestMapping("/jobs/{id}/getApps/{id}/apps")
    public ModelAndView getAppDetailsOnJobPage(@PathVariable Long id) {
        return new ModelAndView("appDetails","apps",appService.getApById(id));
    }


}
