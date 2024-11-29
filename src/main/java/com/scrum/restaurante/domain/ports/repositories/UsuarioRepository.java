package com.scrum.restaurante.domain.ports.repositories;

import com.scrum.restaurante.domain.model.usuario.Usuario;

public interface UsuarioRepository {
    Usuario criar(Usuario usuario);
    void validarNovoUsuario(Usuario usuario);
    Boolean existePorUsername(String username);
    Boolean existePorEmail(String email);
    Usuario editarNome(Usuario usuario);
    Usuario encontrarPorUsername(String username);
    void alterarDoisFatores(Usuario usuario);
}
