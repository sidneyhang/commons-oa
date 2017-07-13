package com.tinthon.coa.controller;

import com.tinthon.coa.mapper.AccountMapper;
import com.tinthon.coa.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * Created by sidne on 2017/7/12.
 */
@RestController
public class HomeController {

    @Autowired
    private AccountMapper accountMapper;


    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView view = new ModelAndView();
        view.setViewName("home");

        List<Map> accounts = accountMapper.findAll();
        for (Map account: accounts) {
            System.out.println(account.get("username"));
            System.out.println(account.get("password"));
            System.out.println(account.get("status"));
            view.addObject("account", account);
        }
        return view;
    }

    @GetMapping("/login")
    public ModelAndView getLogin(@ModelAttribute("account") Account account) {
        ModelAndView view = new ModelAndView();
        view.setViewName("login");
        account.setUsername("yang");
        return view;
    }

    @PostMapping("/login")
    public ModelAndView postLogin(@ModelAttribute("account") Account account) {
        ModelAndView view = new ModelAndView();
        view.setViewName("redirect:/home");
        return view;
    }

}
