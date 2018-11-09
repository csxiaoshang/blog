package com.ashang.blog.Dao;

import com.ashang.blog.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserDao extends JpaRepository<User,String> {
                Optional<User> findByUsername(String username);
}

