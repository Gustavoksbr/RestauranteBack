package com.scrum.restaurante.domain.ports.services;


import com.scrum.restaurante.domain.model.Response;
import com.scrum.restaurante.domain.model.Usuario;

import java.util.List;

public interface UsuarioManager {
//
//    List<Usuario> listarUsuarios(String substring);

    String createUser(Usuario usuario);

    Response authenticate(Usuario usuario);

    String mudarNome(String nome, String token);

//    Response authenticate(Usuario usuario);
//
//    String authenticate2fa(Usuario usuario, String codigo);
//
//    Boolean habilitarDesabilitarDoisFatores(String jwt);
//
//    Usuario alterarnome(Usuario usuario, String username); //
//



}
