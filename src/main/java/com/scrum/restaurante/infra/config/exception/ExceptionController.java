package com.scrum.restaurante.infra.config.exception;

import com.scrum.restaurante.infra.config.exception.exceptions.JaExisteException;
import com.scrum.restaurante.infra.config.exception.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.ConnectException;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
    @ExceptionHandler(JaExisteException.class)
    public ResponseEntity<String> handleJaExiste(JaExisteException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
    @ExceptionHandler(org.springframework.data.redis.RedisConnectionFailureException.class)
    public ResponseEntity<String> handleRedisConnectionException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erro ao conectar ao Redis: ");
    }

}
