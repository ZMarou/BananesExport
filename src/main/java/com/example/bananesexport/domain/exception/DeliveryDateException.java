package com.example.bananesexport.domain.exception;

import org.springframework.http.HttpStatus;

public class DeliveryDateException extends BusinessException {
    public DeliveryDateException(String msg) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, msg);
    }
}
