package com.codegym.restfull.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("acounts")
public class AcountViewController {
    @GetMapping("")
    public ModelAndView getAll(){
        return new ModelAndView("acount");
    }
}
