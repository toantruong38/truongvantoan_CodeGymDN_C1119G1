package com.toantr.webapp.repo;

import com.toantr.webapp.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User,Long>
{
    User getUserByUsername(String username);
}
