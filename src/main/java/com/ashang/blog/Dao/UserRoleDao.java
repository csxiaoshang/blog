package com.ashang.blog.Dao;

import com.ashang.blog.Entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleDao extends JpaRepository<UserRole,Long> {
    UserRole findByUserId(Long userid);
}
