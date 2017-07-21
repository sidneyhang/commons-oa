package com.tinthon.coa.controller;

import com.tinthon.coa.mapper.AccountMapper;
import com.tinthon.coa.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AccountMapper accountMapper;

    private ModelAndView view = new ModelAndView();


    @GetMapping("/list")
    public ModelAndView getUserlist() {
        List<Account> accounts = accountMapper.findListByOption(null);
        view.addObject("accounts", accounts);
        view.setViewName("user_list");
        return view;
    }
}
