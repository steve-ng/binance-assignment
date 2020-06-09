package com.binance.cms.controllers;

import com.binance.cms.api.responses.ArticleResponse;
import com.binance.cms.mappers.ArticleMapper;
import com.binance.cms.services.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/articles")
@Api(value="GET and DEL operations pertaining around getting list of article or deleting article")
public class ArticleController {
    private final ArticleService articleService;
    private final ArticleMapper articleMapper;

    @Autowired
    public ArticleController(ArticleService articleService, ArticleMapper articleMapper) {
        this.articleService = articleService;
        this.articleMapper = articleMapper;
    }

    @ApiOperation(value = "View all the existing articles", response = ArticleResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
    })
    @GetMapping
    public Page<ArticleResponse> getArticles(Pageable pageable) {
        return articleService.getAllArticles(pageable)
                .map(articleMapper::entityToResponse);
    }

    @ApiOperation(value = "Delete article by slug", response = ArticleResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully delete article"),
            @ApiResponse(code = 401, message = "You are not authorized to perform the action"),
    })
    @DeleteMapping("/{slug}")
    public void deleteArticleBySlug(@PathVariable final String slug) {
        articleService.deleteArticleBySlug(slug);
    }
}
