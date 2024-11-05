package com.scrum.restaurante.infra.app.persistence.comanda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaComandaRepository extends JpaRepository<ComandaEntity, Long> {
    List<ComandaEntity> findByMesaIdAndPagaFalse(Long mesaId);
}
