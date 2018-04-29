package com.loyer.hrsystem.controller;

import com.loyer.hrsystem.model.User;

import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")
    public ModelAndView getHomePage(@AuthenticationPrincipal User user) {
        return new ModelAndView("home", "user", user);
    }
}
