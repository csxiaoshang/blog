package com.ashang.blog.Entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class User {
    @Column
    @Id
    private String username;
    @Column
    private String password;
}
