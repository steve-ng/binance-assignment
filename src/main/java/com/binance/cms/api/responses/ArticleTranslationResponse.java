package com.binance.cms.api.responses;

import com.binance.cms.entities.Language;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ArticleTranslationResponse {
    private String slug;

    private String title;

    private Language language;

    private String content;

    private long createdAt;

    private long updatedAt;
}
