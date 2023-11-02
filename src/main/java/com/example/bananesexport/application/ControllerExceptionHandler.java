package com.example.bananesexport.application;

import com.example.bananesexport.domain.exception.BusinessException;
import com.example.bananesexport.domain.exception.DeliveryDateException;
import com.example.bananesexport.domain.exception.QuantityException;
import com.example.bananesexport.domain.exception.RecipientException;
import com.example.bananesexport.domain.exception.BusinessExceptionResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler({DeliveryDateException.class, QuantityException.class, RecipientException.class})
    public ResponseEntity<BusinessExceptionResponse> handleResourceException(BusinessException e,
                                                                             HttpServletRequest request,
                                                                             HttpServletResponse response) {

        HttpHeaders responseHeaders = new HttpHeaders();

        responseHeaders.setContentType(MediaType.APPLICATION_JSON);

        BusinessExceptionResponse exceptionDto = new BusinessExceptionResponse(e.getHttpStatus(), e.getMessage());

        return new ResponseEntity<>(exceptionDto, responseHeaders, e.getHttpStatus());
    }
}
