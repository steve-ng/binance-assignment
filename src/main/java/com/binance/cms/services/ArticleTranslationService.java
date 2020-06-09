package com.binance.cms.services;

import com.binance.cms.api.requests.ArticleTranslationRequest;
import com.binance.cms.entities.ArticleEntity;
import com.binance.cms.entities.ArticleTranslationEntity;
import com.binance.cms.entities.Language;
import com.binance.cms.exceptions.NotExistException;
import com.binance.cms.exceptions.PageTranslationExistException;
import com.binance.cms.respositories.ArticleTranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ArticleTranslationService {
    private final ArticleService articleService;
    private final ArticleTranslationRepository articleTranslationRepository;

    @Autowired
    public ArticleTranslationService(ArticleService articleService, ArticleTranslationRepository articleTranslationRepository) {
        this.articleTranslationRepository = articleTranslationRepository;
        this.articleService = articleService;
    }

    public ArticleTranslationEntity getPageTranslationBySlugAndLanguage(String slug, Language language) {
        final ArticleEntity articleEntity = articleService.findBySlug(slug)
                .orElseThrow(() -> new NotExistException("Slug: "+ slug + " cannot be found"));

        return articleEntity.getTranslation().stream()
                .filter(pageTranslationEntity -> pageTranslationEntity.getLanguage() == language)
                .findFirst()
                .orElseThrow(() -> new NotExistException("Slug: "+ slug + " does not have language: " + language.name() + " translation"));
    }

    @Transactional
    public ArticleTranslationEntity createPageTranslation(ArticleTranslationRequest articleTranslationRequest) {
        final String slug = articleTranslationRequest.getSlug();
        final ArticleEntity articleEntity = articleService.createArticleEntityIfNotExist(slug);

        final Optional<ArticleTranslationEntity> optPageTranslationEntity = articleEntity.getTranslation().stream()
                .filter(entity -> entity.getLanguage() == articleTranslationRequest.getLanguage())
                .findAny();

        if (optPageTranslationEntity.isPresent()) {
            throw new PageTranslationExistException("Slug " + slug + " already have translation for language: " + articleTranslationRequest.getLanguage());
        }

        final ArticleTranslationEntity translationEntity =  ArticleTranslationEntity.builder()
                .page(articleEntity)
                .content(articleTranslationRequest.getContent())
                .language(articleTranslationRequest.getLanguage())
                .title(articleTranslationRequest.getTitle())
                .build();

        articleEntity.addTranslation(translationEntity);
        return articleTranslationRepository.save(translationEntity);
    }

    @Transactional
    public ArticleTranslationEntity updatePageTranslation(String slug, ArticleTranslationRequest articleTranslationRequest) {
        final ArticleEntity articleEntity = articleService.findBySlug(slug)
                .orElseThrow(() -> new NotExistException("Slug: "+ slug + " cannot be found"));

        final Language lang = articleTranslationRequest.getLanguage();
        final ArticleTranslationEntity articleTranslationEntity = articleEntity.getTranslation().stream()
                .filter(entity -> entity.getLanguage() == lang)
                .findAny()
                .orElseThrow(() -> new NotExistException("No page translation lang: " + lang + " for slug: " + slug));

        articleTranslationEntity.setContent(articleTranslationRequest.getContent());
        articleTranslationEntity.setTitle(articleTranslationRequest.getTitle());

        return articleTranslationRepository.save(articleTranslationEntity);
    }

    public void deletePageTranslation(final String slug, final Language lang) {
        final ArticleEntity articleEntity = articleService.findBySlug(slug)
                .orElseThrow(() -> new NotExistException("Slug: "+ slug + " cannot be found"));

        final ArticleTranslationEntity articleTranslationEntity = articleEntity.getTranslation().stream()
                .filter(entity -> entity.getLanguage() == lang)
                .findAny()
                .orElseThrow(() -> new NotExistException("No page translation lang: " + lang + " for slug: " + slug));

        articleTranslationRepository.delete(articleTranslationEntity);
    }
}
