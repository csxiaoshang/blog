package com.ashang.blog.Entity;


import lombok.Data;
import lombok.Value;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String  role;
}
