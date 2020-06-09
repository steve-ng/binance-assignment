package com.binance.cms.respositories;

import com.binance.cms.entities.ArticleTranslationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleTranslationRepository extends CrudRepository<ArticleTranslationEntity, String> {

}
