package com.ashang.blog.Entity;


import lombok.Data;

import javax.persistence.*;
import javax.persistence.criteria.Predicate;

@Data
@Entity
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String high;

    @Column
    private String medium;

    @Column
    private  String low;
}
