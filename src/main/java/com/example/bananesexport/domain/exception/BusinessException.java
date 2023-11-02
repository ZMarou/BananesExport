package com.example.bananesexport.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

@Getter
public class BusinessException extends RuntimeException {

    /**
     * Serialization ID.
     */
    private static final String BASE_DEFAULT = "Error occurred";

    /**
     * HttpStatus of the Error.
     */
    private final HttpStatus httpStatus;

    /**
     * Constructor Method. (Default message and Http status).
     */
    public BusinessException(HttpStatus status, String msg) {
        super(StringUtils.hasText(msg) ? msg : BASE_DEFAULT);
        this.httpStatus = status != null ? status : HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
