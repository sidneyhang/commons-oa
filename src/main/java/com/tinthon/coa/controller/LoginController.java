package com.tinthon.coa.controller;

import com.tinthon.coa.mapper.AccountMapper;
import com.tinthon.coa.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private AccountMapper accountMapper;

    private ModelAndView view = new ModelAndView();

    @GetMapping
    public ModelAndView getLogin(@ModelAttribute("account") Account account, Model model) {
        view.setViewName("login");
        account.setUsername("yang");
        return view;
    }
}
