package com.binance.cms.respositories;

import com.binance.cms.entities.ArticleEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRepository extends PagingAndSortingRepository<ArticleEntity, String> {
    Optional<ArticleEntity> findBySlug(String slug);
}
