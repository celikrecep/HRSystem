package com.loyer.hrsystem.controller;

import com.loyer.hrsystem.model.AppAddForm;
import com.loyer.hrsystem.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AppController {
    private final AppService appService;

    @Autowired
    public AppController(AppService appService) {
        this.appService = appService;
    }


    @RequestMapping(value = "/apps", method = RequestMethod.POST)
    public String handleAppAdd(@Valid @ModelAttribute("appForm") AppAddForm appAddForm, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "addApp";

        appService.addApp(appAddForm);
        return "home";
    }
}
