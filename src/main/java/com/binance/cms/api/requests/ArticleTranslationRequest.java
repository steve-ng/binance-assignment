package com.binance.cms.api.requests;

import com.binance.cms.entities.Language;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class ArticleTranslationRequest {

    @NotBlank
    public String slug;

    @NotBlank
    private String title;

    private Language language;

    @NotBlank
    private String content;
}
