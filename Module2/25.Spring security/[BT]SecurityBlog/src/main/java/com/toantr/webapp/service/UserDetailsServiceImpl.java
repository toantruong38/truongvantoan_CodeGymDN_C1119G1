package com.toantr.webapp.service;

import com.toantr.webapp.model.PdfUserDetails;
import com.toantr.webapp.model.User;
import com.toantr.webapp.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService
{
    private static final Logger log= LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException
    {
        User user=userRepo.getUserByUsername(s);

        if(user==null){
            throw new UsernameNotFoundException("User not found");
        }
        log.info("loadUserByUsername(): {}",s);
        return new PdfUserDetails(user);
    }
}
