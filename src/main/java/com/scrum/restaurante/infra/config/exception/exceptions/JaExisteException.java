package com.scrum.restaurante.infra.config.exception.exceptions;

public class JaExisteException extends RuntimeException {
    public JaExisteException(String message) {
        super(message);
    }
}
