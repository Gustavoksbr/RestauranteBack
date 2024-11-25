package com.scrum.restaurante.domain.ports.repositories;

import com.scrum.restaurante.domain.model.Usuario;
import com.scrum.restaurante.infra.app.persistence.usuario.entity.UserEntity;

public interface UsuarioRepository {
    Usuario criar(Usuario usuario);
    void validarNovoUsuario(Usuario usuario);
    Boolean existePorUsername(String username);
    Boolean existePorEmail(String email);

    Usuario encontrarPorUsername(String username);
}
