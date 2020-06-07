package com.binance.cms.controllers;

import com.binance.cms.api.requests.ArticleTranslationRequest;
import com.binance.cms.api.responses.ArticleTranslationResponse;
import com.binance.cms.entities.ArticleTranslationEntity;
import com.binance.cms.entities.Language;
import com.binance.cms.mappers.PageTranslationMapper;
import com.binance.cms.services.ArticleTranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController("")
@RequestMapping("/v1/page-translations")
public class ArticleTranslationController {

    private final ArticleTranslationService articleTranslationService;
    private final PageTranslationMapper pageTranslationMapper;

    @Autowired
    public ArticleTranslationController(ArticleTranslationService articleTranslationService, PageTranslationMapper pageTranslationMapper) {
        this.articleTranslationService = articleTranslationService;
        this.pageTranslationMapper = pageTranslationMapper;
    }

    @GetMapping("/{slug}")
    public ArticleTranslationResponse getPageBySlugAndLang(@PathVariable final String slug,
                                                           @RequestParam(defaultValue="EN") final Language lang) {
        final ArticleTranslationEntity pageEntity = articleTranslationService.getPageTranslationBySlugAndLanguage(slug, lang);
        return pageTranslationMapper.pageEntityToResponse(pageEntity);
    }

    @PostMapping
    public ArticleTranslationResponse createPageTranslation(@Valid @RequestBody final ArticleTranslationRequest articleTranslationRequest) {
        final ArticleTranslationEntity articleTranslationEntity = articleTranslationService.createPgeTranslation(articleTranslationRequest);
        return pageTranslationMapper.pageEntityToResponse(articleTranslationEntity);
    }

    @PutMapping("/{slug}")
    public ArticleTranslationResponse updatePageTranslation(@PathVariable final String slug,
                                                            @Valid @RequestBody final ArticleTranslationRequest articleTranslationRequest) {
        final ArticleTranslationEntity articleTranslationEntity = articleTranslationService.updatePageTranslation(slug, articleTranslationRequest);
        return pageTranslationMapper.pageEntityToResponse(articleTranslationEntity);
    }

    @DeleteMapping("/{slug}")
    public void deletePageTranslationByLang(@PathVariable final String slug,
                                            @RequestParam(defaultValue="EN") final Language lang) {
        articleTranslationService.deletePageTranslation(slug, lang);
    }
}
