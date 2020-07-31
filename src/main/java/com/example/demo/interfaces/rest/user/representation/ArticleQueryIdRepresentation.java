package com.example.demo.interfaces.rest.user.representation;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 2020/7/31 下午 02:49
 *
 * @author Lai
 * @version 1.0.0
 **/
@Getter
@AllArgsConstructor
public class ArticleQueryIdRepresentation {

    /**
     * 標題.
     */
    private String title;

    /**
     * 內容.
     */
    private String content;

    /**
     * 作者.
     */
    private String author;

    /**
     * 建立時間.
     */
    private String buildDate;

    /**
     * 修改時間.
     */
    private String modifyDate;
}
