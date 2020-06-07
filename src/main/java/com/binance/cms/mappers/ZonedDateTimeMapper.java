package com.binance.cms.mappers;

import org.mapstruct.Mapper;

import java.time.ZonedDateTime;

@Mapper(componentModel = "spring")
public interface ZonedDateTimeMapper {

    default long map(ZonedDateTime zonedDateTime) {
        return zonedDateTime.toEpochSecond();
    }
}
