package com.ashang.blog.Service.impl;

import com.ashang.blog.Dao.UserDao;
import com.ashang.blog.Entity.User;
import com.ashang.blog.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author ashang
 * 18-11-05 11:16am
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public boolean login(User user) {
               Optional<User> u=userDao.findByUsername(user.getUsername());
       if(u.isPresent()){
          if(user.getPassword().equals(u.get().getPassword()))
                return true;
          else
              return false;
       }
       else
           return false;
    }

    @Override
    public void register(User user) {
        User u=new User();
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        userDao.save(user);
    }
}
