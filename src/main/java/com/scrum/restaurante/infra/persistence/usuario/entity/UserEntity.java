package com.scrum.restaurante.infra.persistence.usuario.entity;

import com.scrum.restaurante.domain.model.usuario.Usuario;
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

    @Column(name = "nome", nullable = true)
    private String nome;

    @Column(nullable = true)
    private String email;

    @Column(nullable = false)
    private boolean ativo;

    @Column(name = "dois_fatores", nullable = false)
    private boolean doisFatores;

    public UserEntity() {
    }

    public UserEntity(Usuario usuario) {
        this.username = usuario.getUsername();
        this.password = usuario.getPassword();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.ativo = true;
    }

    public UserEntity(String username, String password, String nome) {
        this.username = username;
        this.password = password;
        this.nome = nome;
        this.ativo = true;
    }

    public Usuario toUsuario() {
        return new Usuario(username, password, nome, email, ativo, doisFatores);
    }

    public void deletar() {
        this.ativo = false;
    }
    public void ativarDoisFatores() {
        this.doisFatores = true;
    }
    public boolean getAtivo() {
        return ativo;
    }


}