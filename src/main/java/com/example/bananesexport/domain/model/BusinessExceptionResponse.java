package com.example.bananesexport.domain.model;

import org.springframework.http.HttpStatus;

public record BusinessExceptionResponse(HttpStatus code, String message) {
}
