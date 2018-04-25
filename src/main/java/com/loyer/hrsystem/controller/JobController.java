package com.loyer.hrsystem.controller;

import com.loyer.hrsystem.model.JobAddForm;
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

@Controller
public class JobController {

    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @RequestMapping("/jobs/add")
    public ModelAndView jobAddPage(){
        return new ModelAndView("addJob", "jobForm", new JobAddForm());
    }

    @RequestMapping(value = "/jobs", method = RequestMethod.POST)
    public String handleJobAdd(@Valid @ModelAttribute("jobForm") JobAddForm form, BindingResult bindingResult){
        if(bindingResult.hasErrors())
        return "addJob";

        jobService.addJob(form);
        return "redirect:/jobs/";
    }

    @RequestMapping("/jobs/")
    public ModelAndView getJobsPage() {
        return new ModelAndView("jobs", "jobs", jobService.getJobs());
    }

    @RequestMapping(value = "/jobs/{id}", method = RequestMethod.DELETE)
    public String handleJobDelete(@PathVariable Long id) {

        jobService.deleteJobById(id);
        return "redirect:/jobs";
    }
}
