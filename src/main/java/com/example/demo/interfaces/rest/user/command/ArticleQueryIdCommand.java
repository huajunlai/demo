package com.example.demo.interfaces.rest.user.command;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * ArticleQueryIdCommand.
 * 2020/7/31 下午 02:42
 *
 * @author Lai
 * @version 1.0.0
 **/
@Data
public class ArticleQueryIdCommand {

    /**
     * Article ID.
     */
    @NotBlank(message = "文章 id 不得為空字串")
    private String articleId;

}
