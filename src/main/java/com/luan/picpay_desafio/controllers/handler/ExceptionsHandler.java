package com.luan.picpay_desafio.controllers.handler;

import com.luan.picpay_desafio.domain.exceptions.ExceptionTemplate;
import com.luan.picpay_desafio.domain.exceptions.InvalidTransaction;
import com.luan.picpay_desafio.domain.exceptions.InvalidUserCreation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(InvalidTransaction.class)
    public ResponseEntity<ExceptionTemplate> exceptionsHandlerResponseEntity(InvalidTransaction e){
        HttpStatus status = HttpStatus.BAD_REQUEST;

        return ResponseEntity.status(status).body(new ExceptionTemplate("Something went wrong", e.getMessage(),"400"));
    }

    @ExceptionHandler(InvalidUserCreation.class)
    public ResponseEntity<ExceptionTemplate> invalidUserCreation(InvalidUserCreation e){
        HttpStatus status = HttpStatus.UNAUTHORIZED;

        return ResponseEntity.status(status).body(new ExceptionTemplate("Something went wrong", e.getMessage(),"401"));
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ExceptionTemplate> httpClientErrorException(HttpClientErrorException e){
        HttpStatus status = HttpStatus.UNAUTHORIZED;

        return ResponseEntity.status(status).body(new ExceptionTemplate("Something went wrong", e.getMessage(),"401"));
    }
}
