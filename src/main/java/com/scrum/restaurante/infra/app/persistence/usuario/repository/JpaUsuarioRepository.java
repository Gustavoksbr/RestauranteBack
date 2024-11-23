package com.scrum.restaurante.infra.app.persistence.usuario.repository;


import com.scrum.restaurante.infra.app.persistence.usuario.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUsuarioRepository extends JpaRepository<UserEntity, String> {

}
