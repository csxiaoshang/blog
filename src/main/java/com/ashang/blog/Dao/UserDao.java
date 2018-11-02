package com.ashang.blog.Dao;

import com.ashang.blog.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,String> {
}
