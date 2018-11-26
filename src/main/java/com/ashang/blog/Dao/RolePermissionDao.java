package com.ashang.blog.Dao;

import com.ashang.blog.Entity.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolePermissionDao extends JpaRepository<RolePermission,Long> {
    RolePermission findByRoleId(Long roleid);
}
