package com.scrum.restaurante.infra.app.persistence.usuario.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private Boolean ativo;

    @Column(name = "dois_fatores", nullable = false)
    private Boolean doisFatores;

}
