package com.ashang.blog.Service.impl;

import com.ashang.blog.Dao.PermissionDao;
import com.ashang.blog.Dao.RolePermissionDao;
import com.ashang.blog.Dao.UserDao;
import com.ashang.blog.Dao.UserRoleDao;
import com.ashang.blog.Entity.User;
import com.ashang.blog.Service.UserManagerSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;


/**
 * @author ashang
 *
 * 18-11-26 20:39pm
 */
@Service
public class UserManagerServiceImpl implements UserManagerSerivce {

    @Autowired
    UserDao userDao;
    @Autowired
    UserRoleDao userRoleDao;
    @Autowired
    PermissionDao permissionDao;
    @Autowired
    RolePermissionDao rolePermissionDao;
    @Override
    public  String isAdmin(HttpSession session){
       User user= (User) session.getAttribute("user");
       Long roleid=userRoleDao.findByUserId(user.getId()).getRoleId();
       Long permissionid=rolePermissionDao.findByRoleId(roleid).getPermissionId();
       String  str=permissionDao.findById(permissionid).get().getHigh();
       return str;
    }

}
