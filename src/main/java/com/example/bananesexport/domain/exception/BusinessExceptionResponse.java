package com.example.bananesexport.domain.exception;

import org.springframework.http.HttpStatus;

public record BusinessExceptionResponse(HttpStatus code, String message) {
}
