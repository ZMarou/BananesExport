package com.example.bananesexport.domain.exception;

import org.springframework.http.HttpStatus;

public class QuantityException extends BusinessException {
    public QuantityException(String msg) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, msg);
    }
}
