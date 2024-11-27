package com.scrum.restaurante.infra.persistence.itemcomanda;

import com.scrum.restaurante.domain.model.ItemComanda;
import com.scrum.restaurante.domain.ports.repositories.ItemComandaRepositoryPort;
import com.scrum.restaurante.config.exception.exceptions.JaExisteException;
import com.scrum.restaurante.config.exception.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ItemComandaRepositoryImpl implements ItemComandaRepositoryPort { //new ResourceNotFoundException("Mesa não encontrada com id"+idMesa))
    @Autowired
    private JpaItemComandaRepository jpaItemComandaRepository;
    private List<ItemComandaEntity> entityListarItensDaComanda(Long idComanda) {
        return jpaItemComandaRepository.findAllByIdComanda(idComanda);
    }
    private boolean existsById(ItemComandaId idItemComanda) {
        return jpaItemComandaRepository.existsById(idItemComanda);
    }

    private ItemComandaEntity findByIdAndNomeProduto(Long idComanda, String nomeProduto) {
        Optional<ItemComandaEntity> itemComandaEntity = jpaItemComandaRepository.findByIdComandaAndNomeProduto(idComanda, nomeProduto);
        return itemComandaEntity.orElseThrow(() -> new ResourceNotFoundException("Item de comanda não encontrado"));
    }



    //implementacoes dos metodos da interface ItemComandaRepositoryPort
    @Override
    public List<ItemComanda> listarItensDaComanda(Long idComanda) {
        return this.entityListarItensDaComanda(idComanda).stream().map(ItemComandaEntity::toModel).toList();
    }

    @Override
    public void adicionarItemComanda(ItemComanda itemComanda) {
        if (this.existsById(new ItemComandaId(itemComanda.getIdComanda(), itemComanda.getIdProduto()) )) {
            throw new JaExisteException("Item de comanda já existe");
        }
        this.jpaItemComandaRepository.save(new ItemComandaEntity(itemComanda));
    }

    @Override
    public void removerItemComanda(long idComanda, String nomeProduto) {
        ItemComandaEntity itemComandaEntity = this.findByIdAndNomeProduto(idComanda, nomeProduto);
        this.jpaItemComandaRepository.delete(itemComandaEntity);
    }
}
