package com.ashang.blog.Entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

/**
 * 用户实体表
 */
@Data
@Entity
@ApiModel
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,unique = true)
    @ApiModelProperty(name = "id",value = "用户ID")
    private Long id;
    @Column
    @ApiModelProperty(name = "username",value = "用户名")
    private String username;
    @Column
    @ApiModelProperty(name = "password",value = "用户密码")
    private String password;
}
