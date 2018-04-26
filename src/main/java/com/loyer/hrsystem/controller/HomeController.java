package com.loyer.hrsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    //get isteği yapıyoruz
    @RequestMapping(value = {"/", "home"})
    public String getHomePage(){
        return "home";
    }
}
