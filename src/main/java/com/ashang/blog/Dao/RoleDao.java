package com.ashang.blog.Dao;

import com.ashang.blog.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role,Long> {
}
