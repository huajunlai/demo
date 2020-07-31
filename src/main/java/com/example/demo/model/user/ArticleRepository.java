package com.example.demo.model.user;

/**
 * ArticleRepository.
 * 2020/7/31 下午 02:23
 *
 * @author Lai
 * @version 1.0.0
 **/
public interface ArticleRepository {

    /**
     * 儲存 Article.
     * @param articleModel -> Article Model
     */
    void save(ArticleModel articleModel);

    /**
     * 取得 Article.
     * @param id -> Article ID.
     * @return Article Model
     */
    ArticleModel findById(String id);

}
