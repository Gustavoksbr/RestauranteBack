package com.scrum.restaurante.domain.services;


import com.scrum.restaurante.domain.model.Response;
import com.scrum.restaurante.domain.model.Usuario;
import com.scrum.restaurante.domain.ports.services.UsuarioManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioManagerImpl implements UsuarioManager {


    @Override
    public List<Usuario> listarUsuarios(String substring) {
        return List.of();
    }

    @Override
    public String createUser(Usuario usuario) {
        return "";
    }

    @Override
    public Response authenticate(Usuario usuario) {
        return null;
    }

    @Override
    public String authenticate2fa(Usuario usuario, String codigo) {
        return "";
    }

    @Override
    public Boolean habilitarDesabilitarDoisFatores(String jwt) {
        return null;
    }

    @Override
    public Usuario alterarnome(Usuario usuario, String nome) {
        return null;
    }
}
