package com.example.demo.model.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * ArticleRepositoryImpl.
 * 2020/7/31 下午 02:26
 *
 * @author Lai
 * @version 1.0.0
 **/
@RequiredArgsConstructor
@Component
public class ArticleRepositoryImpl implements ArticleRepository {

    /**
     * EntityManager.
     */
    private final EntityManager entityManager;

    @Override
    public void save(final ArticleModel articleModel) {
        entityManager.merge(articleModel);
    }

    @Override
    public ArticleModel findById(final String id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ArticleModel> query = cb.createQuery(ArticleModel.class);
        Root<ArticleModel> root = query.from(
                ArticleModel.class
        );
        query.select(root);
        query.where(
                cb.equal(
                        root.get("id"),
                        id
                )
        );
        try {
            return entityManager.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
