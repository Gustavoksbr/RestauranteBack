package com.scrum.restaurante.domain.ports.manager;


import com.scrum.restaurante.domain.model.usuario.AuthResponse;
import com.scrum.restaurante.domain.model.usuario.Usuario;

public interface UsuarioManager {
//
//    List<Usuario> listarUsuarios(String substring);

    String createUser(Usuario usuario);

    AuthResponse authenticate(Usuario usuario);

    String mudarNome(String nome, String token);

    Boolean habilitarDesabilitarDoisFatores(String token);

    String authenticate2fa(Usuario usuario, String codigo);

//    AuthResponse authenticate(Usuario usuario);
//
//    String authenticate2fa(Usuario usuario, String codigo);
//
//    Boolean habilitarDesabilitarDoisFatores(String jwt);
//
//    Usuario alterarnome(Usuario usuario, String username); //
//



}
