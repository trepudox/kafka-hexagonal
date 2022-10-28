package com.trepudox.kafkahexagonal.infrastructure.exception;

import com.trepudox.kafkahexagonal.application.exception.ClienteImpactadoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ClienteImpactadoNaoEncontradoException.class)
    public ResponseEntity<Object> handleClienteImpactadoNaoEncontradoException(ClienteImpactadoNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
