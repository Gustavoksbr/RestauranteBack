package com.scrum.restaurante.infra.app.persistence.itemcomanda;

import com.scrum.restaurante.domain.model.ItemComanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaItemComandaRepository extends JpaRepository<ItemComandaEntity, Long> {
    public List<ItemComandaEntity> findAllByIdComanda(Long idComanda);
}
