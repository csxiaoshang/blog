package com.ashang.blog.Entity;


import lombok.Data;

import javax.persistence.*;

/**
 * RBAC模型 角色权限关联表
 */
@Data
@Entity
public class RolePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private  Long roleId;

    @Column
    private Long permissionId;
}
