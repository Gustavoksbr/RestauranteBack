package com.scrum.restaurante.infra.persistence.itemcomanda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaItemComandaRepository extends JpaRepository<ItemComandaEntity, ItemComandaId> {

    List<ItemComandaEntity> findAllByIdComanda(Long idComanda);
    Optional<ItemComandaEntity> findByIdComandaAndNomeProduto(Long idComanda, String nomeProduto);
}
