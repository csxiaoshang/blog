package com.ashang.blog.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ArticleCommon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long articleID;

    @Column
    private String articleTitle;

    @Column
    private String articleDescription;

    @Column
    private  String articleContent;

    @Column String articleTag;
}
