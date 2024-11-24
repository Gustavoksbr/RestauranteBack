package com.scrum.restaurante.infra.app.persistence.usuario.repository;


import com.scrum.restaurante.domain.model.Usuario;
import com.scrum.restaurante.domain.ports.repositories.UsuarioRepository;
import com.scrum.restaurante.infra.app.persistence.usuario.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UsuarioRepositoryImpl implements UsuarioRepository {
    @Autowired
    private JpaUsuarioRepository jpaUsuarioRepository;


    @Override
    public Usuario criar(Usuario usuario) {
        return this.jpaUsuarioRepository.save(new UserEntity(usuario)).toUsuario();
    }
}
