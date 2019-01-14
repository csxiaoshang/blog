package com.ashang.blog.Service.impl;

import com.ashang.blog.Dao.*;
import com.ashang.blog.Entity.Role;
import com.ashang.blog.Entity.User;
import com.ashang.blog.Entity.UserD;
import com.ashang.blog.Entity.UserRole;
import com.ashang.blog.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 用户业务逻辑类
 * @author ashang
 * 18-11-05 11:16am
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    UserRoleDao userRoleDao;
    @Autowired
    PermissionDao permissionDao;
    @Autowired
    RolePermissionDao rolePermissionDao;
    @Autowired
    RoleDao roleDao;

    /**
     * 用户登录方法
     * @param user
     * @return 布尔型参数 用来判断用户是否登录成功
     */
    @Override
    public boolean login(User user) {
               Optional<User> u=userDao.findByUsername(user.getUsername());
//               u.ifPresent(user1-> user.setId(user1.getId()));
       if(u.isPresent()){
          if(user.getPassword().equals(u.get().getPassword())){
              user.setId(u.get().getId());
              return true;
          }
          else
              return false;
       }
       else
           return false;
    }

    /**
     * 用户注册方法
     * @param user
     */
    @Override
    public void register(User user) {
        User u=new User();
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        userDao.save(user);
    }

    /**
     * 查询所有用户
     * @return UserD  用户ID  用户名 用户角色
     */
    @Override
    public List<UserD> findAll(){
        List<UserD> userDS=new ArrayList<>();
        List<User> users= userDao.findAll();
        for (User user:
             users) {
            UserD userD=new UserD();
            userD.setId(user.getId());
            userD.setUsername(user.getUsername());
           Long reid=userRoleDao.findByUserId(user.getId()).getRoleId();
            Optional<Role> role = roleDao.findById(reid);
            String  str = null;
            if (role.isPresent()){
                str=role.get().getRole();
            }
            userD.setRole(str);
            userDS.add(userD);
        }
        return userDS;
    }
}
