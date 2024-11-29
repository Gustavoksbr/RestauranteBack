package com.scrum.restaurante.domain.model.usuario;

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

    public Usuario(String username, String email, String senha) {
        this.username = username;
        this.email = email;
        this.password = senha;
    }
    public Usuario(String username,  String senha) {
        this.username = username;
        this.password = senha;
    }
}
