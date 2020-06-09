package com.binance.cms.api.responses;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ArticleResponse {
    private String slug;

    private long createdAt;

    private long updatedAt;
}
