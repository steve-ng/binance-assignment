package com.binance.cms.respositories;

import com.binance.cms.entities.ArticleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PageRepository extends CrudRepository<ArticleEntity, String> {

    Optional<ArticleEntity> findBySlug(String slug);
}
