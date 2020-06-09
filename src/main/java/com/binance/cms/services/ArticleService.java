package com.binance.cms.services;

import com.binance.cms.entities.ArticleEntity;
import com.binance.cms.exceptions.NotExistException;
import com.binance.cms.respositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Page<ArticleEntity> getAllArticles(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

    public void deleteArticleBySlug(String slug) {
         final ArticleEntity entity = articleRepository.findBySlug(slug)
                 .orElseThrow(() -> new NotExistException("No slug " + slug + " exist."));

         articleRepository.delete(entity);
    }

    public ArticleEntity createArticleEntityIfNotExist(String slug) {
        return articleRepository.findBySlug(slug)
                .orElseGet(() -> {
                    final ArticleEntity entity = ArticleEntity.builder().slug(slug).build();
                    return articleRepository.save(entity);
                });
    }

    public Optional<ArticleEntity> findBySlug(String slug) {
        return articleRepository.findBySlug(slug);
    }
}
