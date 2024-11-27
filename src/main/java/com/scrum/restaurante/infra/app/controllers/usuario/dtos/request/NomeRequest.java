package com.scrum.restaurante.infra.app.controllers.usuario.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class NomeRequest {
    @NotBlank
    private String nome;
}
