package com.binance.cms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PageTranslationExistException extends ResponseStatusException {

    public PageTranslationExistException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
