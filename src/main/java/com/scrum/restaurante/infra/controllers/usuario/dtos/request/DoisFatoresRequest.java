package com.scrum.restaurante.infra.controllers.usuario.dtos.request;

import lombok.Data;

@Data
public class DoisFatoresRequest {
    private String username;
    private String password;
    private String codigo;
}
