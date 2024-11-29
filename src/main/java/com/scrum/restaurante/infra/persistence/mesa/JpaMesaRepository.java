package com.scrum.restaurante.infra.persistence.mesa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaMesaRepository extends JpaRepository<MesaEntity, Long> {
}
