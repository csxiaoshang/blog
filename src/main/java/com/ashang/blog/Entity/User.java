package com.ashang.blog.Entity;


import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

/**
 * 用户实体表
 */
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,unique = true)
    private Long id;
    @Column
    private String username;
    @Column
    private String password;
}
