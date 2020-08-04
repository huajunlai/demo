package com.example.demo.service.user;

import com.example.demo.interfaces.rest.user.command.ArticleQueryIdCommand;
import com.example.demo.interfaces.rest.user.representation.ArticleQueryIdRepresentation;
import com.example.demo.model.user.ArticleModel;
import com.example.demo.model.user.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * ArticleService.
 * 2020/7/31 下午 02:35
 *
 * @author Lai
 * @version 1.0.0
 *
 **/
@Service
@RequiredArgsConstructor
@Validated
@Slf4j
public class ArticleService {

    /**
     * ArticleRepository.
     */
    @NotNull
    private final ArticleRepository articleRepository;

    /**
     * 透過 Article ID 查詢 ArticleModel.
     * @param command -> ArticleQueryIdCommand
     * @return ArticleQueryIdRepresentation
     * @throws NoResultException
     */
    @Transactional
    public ArticleQueryIdRepresentation findArticleById(
            @Valid final ArticleQueryIdCommand command
    ) throws NoResultException {
        ArticleModel result = articleRepository.findById(
                command.getArticleId()
        );
        if (result == null) {
            log.warn("ArticleID:[{}] is not found in DB.", command.getArticleId());
            throw new NoResultException(
                    "No data result."
            );
        }
        return new ArticleQueryIdRepresentation(
                result.getTitle(),
                result.getContent(),
                result.getAuthor(),
                result.getBuildDate(),
                result.getModifyDate()
        );
    }

    /**
     * 新增一筆 Article.
     * @param title -> 標題
     * @param content -> 文章
     * @param author -> 作者
     */
    @Transactional(rollbackOn = Exception.class)
    public void insertArticle(
            final String title,
            final String content,
            final String author
    ) {
        ArticleModel data = ArticleModel.create(
                title,
                content,
                author
        );
        articleRepository.save(data);
    }

}
