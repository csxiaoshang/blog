package com.ashang.blog.Entity;


import lombok.Data;

import javax.persistence.*;

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
