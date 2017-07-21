package com.tinthon.coa.controller;

import com.tinthon.coa.mapper.AccountMapper;
import com.tinthon.coa.mapper.UserMapper;
import com.tinthon.coa.model.Account;
import com.tinthon.coa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    @Qualifier("org.springframework.security.authenticationManager")
    protected AuthenticationManager authenticationManager;

    private ModelAndView view = new ModelAndView();

    @GetMapping
    public ModelAndView getRegister(@ModelAttribute("account")Account account) {
        view.setViewName("register");
        return view;
    }

    @PostMapping
    public ModelAndView postRegister(@ModelAttribute("account") Account account, @RequestParam("fullname") String fullName) {
        accountMapper.insertSelective(account);
        System.out.println(account.getId());
        if (account.getId() > 0) {
            User user = new User();
            user.setId(account.getId());
            user.setFullName(fullName);
            userMapper.insertSelective(user);
        }

        try {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword());
            token.setDetails(new WebAuthenticationDetails(request));
            Authentication authentication = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
        } catch (Exception e) {
            SecurityContextHolder.getContext().setAuthentication(null);
            e.printStackTrace();
        }
        view.setViewName("redirect:/home");
        return view;
    }
}
