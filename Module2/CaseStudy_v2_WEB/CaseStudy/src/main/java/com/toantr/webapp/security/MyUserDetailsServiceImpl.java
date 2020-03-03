package com.toantr.webapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsServiceImpl implements UserDetailsService
{
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException
    {
        User user=userRepo.findByUsername(s);
        if(user==null) throw new UsernameNotFoundException("User {"+s+"} not found!");

        System.out.printf("Load user w/ username: {%s}",s);
        return new MyUserDetails(user);
    }
}
