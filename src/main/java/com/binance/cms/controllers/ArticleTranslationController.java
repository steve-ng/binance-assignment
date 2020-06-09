package com.binance.cms.controllers;

import com.binance.cms.api.requests.ArticleTranslationRequest;
import com.binance.cms.api.responses.ArticleTranslationResponse;
import com.binance.cms.entities.ArticleTranslationEntity;
import com.binance.cms.entities.Language;
import com.binance.cms.mappers.ArticleTranslationMapper;
import com.binance.cms.services.ArticleTranslationService;
import io.swagger.annotations.ApiOperation;
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

@RestController
@RequestMapping("/v1/article-translations")
public class ArticleTranslationController {

    private final ArticleTranslationService articleTranslationService;
    private final ArticleTranslationMapper articleTranslationMapper;

    @Autowired
    public ArticleTranslationController(ArticleTranslationService articleTranslationService, ArticleTranslationMapper articleTranslationMapper) {
        this.articleTranslationService = articleTranslationService;
        this.articleTranslationMapper = articleTranslationMapper;
    }

    @ApiOperation(value = "Get article translation by slug and language", response = ArticleTranslationResponse.class)
    @GetMapping("/{slug}")
    public ArticleTranslationResponse getPageBySlugAndLang(@PathVariable final String slug,
                                                           @RequestParam(defaultValue="EN") final Language lang) {
        final ArticleTranslationEntity pageEntity = articleTranslationService.getPageTranslationBySlugAndLanguage(slug, lang);
        return articleTranslationMapper.entityToResponse(pageEntity);
    }

    @ApiOperation(value = "Create an article translation", response = ArticleTranslationResponse.class)
    @PostMapping
    public ArticleTranslationResponse createPageTranslation(@Valid @RequestBody final ArticleTranslationRequest articleTranslationRequest) {
        final ArticleTranslationEntity articleTranslationEntity = articleTranslationService.createPageTranslation(articleTranslationRequest);
        return articleTranslationMapper.entityToResponse(articleTranslationEntity);
    }

    @ApiOperation(value = "Update article translation by slug", response = ArticleTranslationResponse.class)
    @PutMapping("/{slug}")
    public ArticleTranslationResponse updatePageTranslation(@PathVariable final String slug,
                                                            @Valid @RequestBody final ArticleTranslationRequest articleTranslationRequest) {
        final ArticleTranslationEntity articleTranslationEntity = articleTranslationService.updatePageTranslation(slug, articleTranslationRequest);
        return articleTranslationMapper.entityToResponse(articleTranslationEntity);
    }

    @ApiOperation(value = "Delete an article translation")
    @DeleteMapping("/{slug}")
    public void deletePageTranslationByLang(@PathVariable final String slug,
                                            @RequestParam(defaultValue="EN") final Language lang) {
        articleTranslationService.deletePageTranslation(slug, lang);
    }
}
