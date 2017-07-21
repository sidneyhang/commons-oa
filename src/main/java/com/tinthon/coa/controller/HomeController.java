package com.tinthon.coa.controller;

import com.tinthon.coa.mapper.AccountMapper;
import com.tinthon.coa.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
public class HomeController {

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private JedisPool jedisPool;

    private ModelAndView view = new ModelAndView();

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView view = new ModelAndView();
        view.setViewName("home");
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(userDetails.getUsername());

        List<Account> accounts = accountMapper.findListByOption(null);
        view.addObject("accounts", accounts);
        return view;
    }

    //    @PostMapping("/login")
    public ModelAndView postLogin(@ModelAttribute("account") Account account, Model model) {
        Jedis jedis = jedisPool.getResource();
        jedis.set("username", account.getUsername());
        jedis.set("password", account.getPassword());
        jedis.close();
        view.setViewName("redirect:/home");
        return view;
    }

}
