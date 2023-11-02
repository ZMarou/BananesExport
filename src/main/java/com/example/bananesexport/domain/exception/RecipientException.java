package com.example.bananesexport.domain.exception;

import org.springframework.http.HttpStatus;

public class RecipientException extends BusinessException {
    public RecipientException(String msg) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, msg);
    }
}
