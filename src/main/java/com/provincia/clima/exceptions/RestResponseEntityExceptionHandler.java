package com.provincia.clima.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {



    //metodo para manejar errores 401  ->Unauthorized
    @ExceptionHandler({ HttpClientErrorException.Unauthorized.class })
    protected ResponseEntity<Object> handleUnauthorized(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, "No estás autorizado para acceder a este recurso", new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }

    //metodo para manejar errores 404   ->  NOT FOUND
    @ExceptionHandler({ HttpClientErrorException.NotFound.class })
    protected ResponseEntity<Object> handleNotFound(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, "Recurso no encontrado", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}