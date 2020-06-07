package com.binance.cms.mappers;

import com.binance.cms.api.responses.ArticleTranslationResponse;
import com.binance.cms.entities.ArticleTranslationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {ZonedDateTimeMapper.class}
)
public interface PageTranslationMapper {

    @Mapping(source = "entity.page.slug", target = "slug")
    ArticleTranslationResponse pageEntityToResponse(ArticleTranslationEntity entity);
}
