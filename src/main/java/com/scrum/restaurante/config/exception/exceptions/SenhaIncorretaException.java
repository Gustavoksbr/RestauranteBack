package com.scrum.restaurante.config.exception.exceptions;

public class SenhaIncorretaException extends RuntimeException{
    public SenhaIncorretaException() {
        super("Senha incorreta");
    }
}
