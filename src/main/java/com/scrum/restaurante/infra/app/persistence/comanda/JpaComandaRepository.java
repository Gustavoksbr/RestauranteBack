package com.scrum.restaurante.infra.app.persistence.comanda;

import com.scrum.restaurante.infra.app.persistence.comanda.entities.ComandaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaComandaRepository extends JpaRepository<ComandaEntity, Long> {
    List<ComandaEntity> findByIdMesaAndPagaFalse(Long mesaId);
    List<ComandaEntity> findAllByPagaTrue();
}
