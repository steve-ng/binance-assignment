package com.binance.cms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NotExistException extends ResponseStatusException {

    public NotExistException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}