package com.scrum.restaurante.infra.app.persistence.itemcomanda;

import com.scrum.restaurante.domain.model.ItemComanda;
import com.scrum.restaurante.domain.ports.repositories.ItemComandaRepositoryPort;
import com.scrum.restaurante.infra.config.exception.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemComandaRepositoryImpl implements ItemComandaRepositoryPort { //new ResourceNotFoundException("Mesa não encontrada com id"+idMesa))
    @Autowired
    private JpaItemComandaRepository jpaItemComandaRepository;
    private List<ItemComandaEntity> entityListarItensDaComanda(Long idComanda) {
        return jpaItemComandaRepository.findAllByIdComanda(idComanda);
    }

    //implementacoes dos metodos da interface ItemComandaRepositoryPort
    @Override
    public List<ItemComanda> listarItensDaComanda(Long idComanda) {
        return this.entityListarItensDaComanda(idComanda).stream().map(ItemComandaEntity::toModel).toList();
    }

    @Override
    public void adicionarItemComanda(ItemComanda itemComanda) {

    }

    @Override
    public void removerItemComanda(Long idItemComanda) {

    }
}
