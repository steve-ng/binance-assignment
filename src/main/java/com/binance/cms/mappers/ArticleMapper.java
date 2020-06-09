package com.binance.cms.mappers;


import com.binance.cms.api.responses.ArticleResponse;
import com.binance.cms.entities.ArticleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {ZonedDateTimeMapper.class}
)
public interface ArticleMapper {
    ArticleResponse entityToResponse(ArticleEntity entity);
}
