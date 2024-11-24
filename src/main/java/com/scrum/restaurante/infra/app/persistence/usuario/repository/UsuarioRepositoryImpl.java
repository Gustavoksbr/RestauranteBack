package com.scrum.restaurante.infra.app.persistence.usuario.repository;


import com.scrum.restaurante.domain.model.Usuario;
import com.scrum.restaurante.domain.ports.repositories.UsuarioRepository;
import com.scrum.restaurante.infra.app.persistence.usuario.entity.UserEntity;
import com.scrum.restaurante.infra.config.exception.exceptions.JaExisteException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class UsuarioRepositoryImpl implements UsuarioRepository {
    @Autowired
    private JpaUsuarioRepository jpaUsuarioRepository;

    @Override
    public Boolean existePorUsername(String username) {
        return this.jpaUsuarioRepository.existsByUsername(username);
    }
    @Override
    public Boolean existePorEmail(String email) {
        return this.jpaUsuarioRepository.existsByEmail(email);
    }
//    @Override
//    public List<Usuario> listar() {
//        return this.jpaUsuarioRepository.findAllByAtivoTrue().stream().map(UserEntity::toUsuario).toList();
//    }

    @Override
    public Usuario criar(Usuario usuario) {
        return this.jpaUsuarioRepository.save(new UserEntity(usuario)).toUsuario();
    }

    @Override
    public void  validarNovoUsuario(Usuario usuario) {
        String username = usuario.getUsername();
        String email = usuario.getEmail();
        if (this.existePorUsername(usuario.getUsername())) {
            throw new JaExisteException("Usuario com username " + username + " já existe");
        }
        if (this.existePorEmail(usuario.getEmail())) {
            throw new JaExisteException("Usuario com email " + email + " já existe");
        }
    }
}
