package com.example.challenge.exceptions;

import com.example.challenge.restservice.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {

        String errorResponseDescription = ex.getLocalizedMessage();

        if (errorResponseDescription == null) errorResponseDescription = ex.toString();

        ErrorResponse errorResponse = new ErrorResponse(new Date(), errorResponseDescription);
        return new ResponseEntity<>(
                errorResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
