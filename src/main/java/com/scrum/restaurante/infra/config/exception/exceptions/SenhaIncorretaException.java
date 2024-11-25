package com.scrum.restaurante.infra.config.exception.exceptions;

public class SenhaIncorretaException extends RuntimeException{
    public SenhaIncorretaException() {
        super("Senha incorreta");
    }
}
