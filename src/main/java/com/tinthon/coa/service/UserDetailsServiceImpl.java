package com.tinthon.coa.service;

import com.tinthon.coa.mapper.AccountMapper;
import com.tinthon.coa.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sidney on 2017/2/23.
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountMapper.findByUsername(username);
        if (account != null) {
            List<GrantedAuthority> authorityList = new ArrayList<GrantedAuthority>();
            authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));

            return new User(
                    account.getUsername(),
                    account.getPassword(),
                    authorityList
            );
        }
        throw new UsernameNotFoundException(
                "User '" + username + "' not found."
        );
    }
}
