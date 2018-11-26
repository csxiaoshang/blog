package com.ashang.blog.Dao;

import com.ashang.blog.Entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionDao extends JpaRepository<Permission,Long> {
}
