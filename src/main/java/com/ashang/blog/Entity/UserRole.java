package com.ashang.blog.Entity;


import lombok.Data;

import javax.persistence.*;

/**
 * 用户角色关联表
 */
@Data
@Entity
public class UserRole {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Long userId;

    @Column
    private Long roleId;
}
