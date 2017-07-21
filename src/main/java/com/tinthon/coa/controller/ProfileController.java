package com.tinthon.coa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private ModelAndView view = new ModelAndView();

    @GetMapping
    public ModelAndView getProfile() {

        view.setViewName("profile");
        return view;
    }

}
