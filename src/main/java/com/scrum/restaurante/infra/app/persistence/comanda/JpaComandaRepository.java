package com.scrum.restaurante.infra.app.persistence.comanda;

import com.scrum.restaurante.infra.app.persistence.mesa.MesaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaComandaRepository extends JpaRepository<ComandaEntity, Long> {
    List<ComandaEntity> findByMesaId(Long mesaId);
}
