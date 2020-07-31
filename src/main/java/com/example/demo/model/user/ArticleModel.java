package com.example.demo.model.user;


import com.example.demo.infrastructure.util.DateTimeUtil;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

/**
 * Article Model.
 * 2020/7/31 下午 01:44
 *
 * @author Lai
 * @version 1.0.0
 **/
@Entity
@Getter
@Setter
@Table(name = "article")
public class ArticleModel implements Serializable {

    public static ArticleModel create(
            final String title,
            final String content,
            final String author
    ) {
        return new ArticleModel(
                UUID.randomUUID().toString(),
                title,
                content,
                author,
                DateTimeUtil.getDateTime()
        );
    }

    /**
     * Default Constructor.
     */
    ArticleModel() {}

    ArticleModel(
            final String id,
            final String title,
            final String content,
            final String author,
            final String buildDate
    ) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.buildDate = buildDate;
    }

    @Id
    private String id;

    @Column(
            columnDefinition = "varchar(30)"
    )
    private String title;

    @Column(
            columnDefinition = "text"
    )
    private String content;

    @Column(
            columnDefinition = "varchar(20)"
    )
    private String author;

    @Column(
            columnDefinition = "varchar(17)"
    )
    private String buildDate;

    @Column(
            columnDefinition = "varchar(17)"
    )
    private String modifyDate;

}
