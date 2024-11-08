package com.scrum.restaurante.infra.app.persistence.itemcomanda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaItemComandaRepository extends JpaRepository<ItemComandaEntity, ItemComandaId> {
    public List<ItemComandaEntity> findAllByIdComanda(Long idComanda);
}
