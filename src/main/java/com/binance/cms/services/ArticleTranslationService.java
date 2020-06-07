package com.binance.cms.services;

import com.binance.cms.api.requests.ArticleTranslationRequest;
import com.binance.cms.entities.ArticleEntity;
import com.binance.cms.entities.ArticleTranslationEntity;
import com.binance.cms.entities.Language;
import com.binance.cms.exceptions.NotExistException;
import com.binance.cms.exceptions.PageTranslationExistException;
import com.binance.cms.respositories.PageRepository;
import com.binance.cms.respositories.PageTranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ArticleTranslationService {
    private final PageRepository pageRepository;
    private final PageTranslationRepository pageTranslationRepository;

    @Autowired
    public ArticleTranslationService(PageRepository pageRepository, PageTranslationRepository pageTranslationRepository) {
        this.pageRepository = pageRepository;
        this.pageTranslationRepository = pageTranslationRepository;
    }

    public ArticleTranslationEntity getPageTranslationBySlugAndLanguage(String slug, Language language) {
        final ArticleEntity articleEntity = pageRepository.findBySlug(slug)
                .orElseThrow(() -> new NotExistException("Slug: "+ slug + " cannot be found"));

        final ArticleTranslationEntity translationEntity = articleEntity.getTranslation().stream()
                .filter(pageTranslationEntity -> pageTranslationEntity.getLanguage() == language)
                .findFirst()
                .orElseThrow(() -> new NotExistException("Slug: "+ slug + " does not have language: " + language.name() + " translation"));

        return translationEntity;
    }

    @Transactional
    public ArticleTranslationEntity createPgeTranslation(ArticleTranslationRequest articleTranslationRequest) {
        final String slug = articleTranslationRequest.getSlug();
        final ArticleEntity articleEntity = pageRepository.findBySlug(slug)
                .orElseGet(() -> {
                    final ArticleEntity entity = ArticleEntity.builder().slug(slug).build();
                    return pageRepository.save(entity);
                });

        final Optional<ArticleTranslationEntity> optPageTranslationEntity = articleEntity.getTranslation().stream()
                .filter(entity -> entity.getLanguage() == articleTranslationRequest.getLanguage())
                .findAny();

        if (optPageTranslationEntity.isPresent()) {
            throw new PageTranslationExistException("Slug " + slug + " already have translation: " + slug);
        }

        final ArticleTranslationEntity translationEntity =  ArticleTranslationEntity.builder()
                .page(articleEntity)
                .content(articleTranslationRequest.getContent())
                .language(articleTranslationRequest.getLanguage())
                .title(articleTranslationRequest.getTitle())
                .build();

        articleEntity.addTranslation(translationEntity);
        return pageTranslationRepository.save(translationEntity);
    }

    @Transactional
    public ArticleTranslationEntity updatePageTranslation(String slug, ArticleTranslationRequest articleTranslationRequest) {
        final ArticleEntity articleEntity = pageRepository.findBySlug(slug)
                .orElseThrow(() -> new NotExistException("Slug: "+ slug + " cannot be found"));

        final Language lang = articleTranslationRequest.getLanguage();
        final ArticleTranslationEntity articleTranslationEntity = articleEntity.getTranslation().stream()
                .filter(entity -> entity.getLanguage() == lang)
                .findAny()
                .orElseThrow(() -> new NotExistException("No page translation lang: " + lang + " for slug: " + slug));

        articleTranslationEntity.setContent(articleTranslationRequest.getContent());
        articleTranslationEntity.setTitle(articleTranslationRequest.getTitle());

        return pageTranslationRepository.save(articleTranslationEntity);
    }

    public void deletePageTranslation(final String slug, final Language lang) {
        final ArticleEntity articleEntity = pageRepository.findBySlug(slug)
                .orElseThrow(() -> new NotExistException("Slug: "+ slug + " cannot be found"));

        final ArticleTranslationEntity articleTranslationEntity = articleEntity.getTranslation().stream()
                .filter(entity -> entity.getLanguage() == lang)
                .findAny()
                .orElseThrow(() -> new NotExistException("No page translation lang: " + lang + " for slug: " + slug));

        pageTranslationRepository.delete(articleTranslationEntity);
    }
}
