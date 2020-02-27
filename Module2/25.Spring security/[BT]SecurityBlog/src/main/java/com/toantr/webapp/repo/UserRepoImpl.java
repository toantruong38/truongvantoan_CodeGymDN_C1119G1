package com.toantr.webapp.repo;

import com.toantr.webapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserRepoImpl
{
    @Autowired
    private UserRepo userRepo;

    User getUserByUsername(String username){
        return userRepo.getUserByUsername(username);
    }
}
