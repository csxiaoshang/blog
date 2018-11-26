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
    private Boolean high;

    @Column
    private Boolean medium;

    @Column
    private  Boolean low;
}
