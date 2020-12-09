package com.intouch.controller;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dangdang")
public class DangdangController {


    @GetMapping("/main")
    public String showMainPage(){
        return "MainPage";
    }



}
