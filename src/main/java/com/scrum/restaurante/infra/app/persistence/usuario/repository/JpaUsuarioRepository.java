package com.scrum.restaurante.infra.app.persistence.usuario.repository;


import com.scrum.restaurante.infra.app.persistence.usuario.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaUsuarioRepository extends JpaRepository<UserEntity, String> {
  public Boolean existsByUsername(String username);
    public Boolean existsByEmail(String email);
}
