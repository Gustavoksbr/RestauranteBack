package com.scrum.restaurante.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private String username;
    private String password;
    private String nome;
    private String email;
    private Boolean ativo;
    private Boolean doisFatores;
}
