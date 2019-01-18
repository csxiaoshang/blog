package com.ashang.blog.Service.impl;

import com.ashang.blog.Dao.PermissionDao;
import com.ashang.blog.Dao.RolePermissionDao;
import com.ashang.blog.Dao.UserDao;
import com.ashang.blog.Dao.UserRoleDao;
import com.ashang.blog.Entity.Constant.Status;
import com.ashang.blog.Entity.Response.Resp;
import com.ashang.blog.Entity.User;
import com.ashang.blog.Entity.Utils.RespUtil;
import com.ashang.blog.Service.UserManagerSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;


/**
 * 管理员管理用户逻辑类
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

    /**
     * 判断是否拥有管理员权限
     * @param session
     * @return 权限标志
     */
    @Override
    public Resp isAdmin(HttpSession session){
       User user= (User) session.getAttribute("user");
       Long roleid=userRoleDao.findByUserId(user.getId()).getRoleId();
       Long permissionid=rolePermissionDao.findByRoleId(roleid).getPermissionId();
       String  str=permissionDao.findById(permissionid).get().getHigh();
       return str.equals("true")? RespUtil.successResp():RespUtil.errorResp(Status.Api.ERROR.getCode(),Status.Api.ERROR.getMsg());
    }

}
