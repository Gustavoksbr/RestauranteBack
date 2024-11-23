package com.scrum.restaurante.infra.app.persistence.usuario.repository;


import com.scrum.restaurante.domain.ports.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UsuarioRepositoryImpl implements UsuarioRepository {
    @Autowired
    private JpaUsuarioRepository jpaUsuarioRepository;


}
