package com.tinthon.coa.controller;

import com.tinthon.coa.mapper.AccountMapper;
import com.tinthon.coa.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Map;

/**
 * Created by sidne on 2017/7/12.
 */
@RestController
@SessionAttributes("username")
public class HomeController {

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private JedisPool jedisPool;

    private ModelAndView view = new ModelAndView();


    @GetMapping("/home")
    public ModelAndView home(@SessionAttribute(value = "username") String username) {
        ModelAndView view = new ModelAndView();
        view.setViewName("home");

        System.out.println(username);

        List<Map> accounts = accountMapper.findAll();
        for (Map account: accounts) {
            view.addObject("account", account);
        }
        return view;
    }

    @GetMapping("/login")
    public ModelAndView getLogin(@ModelAttribute("account") Account account) {
        view.setViewName("login");
        account.setUsername("yang");
        return view;
    }

    @PostMapping("/my/login")
    public ModelAndView postLogin(@ModelAttribute("account") Account account, Model model) {
        model.addAttribute("username", account.getUsername());
        Jedis jedis = jedisPool.getResource();
        jedis.set("username", account.getUsername());
        jedis.set("password", account.getPassword());
        jedis.close();
        view.setViewName("redirect:/home");
        return view;
    }

}
