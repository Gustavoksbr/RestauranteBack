package com.scrum.restaurante.domain.ports.repositories;

import com.scrum.restaurante.domain.model.ItemComanda;
import com.scrum.restaurante.infra.app.persistence.itemcomanda.ItemComandaId;

import java.util.List;

public interface ItemComandaRepositoryPort {
    public List<ItemComanda> listarItensDaComanda(Long idComanda);
    public void adicionarItemComanda(ItemComanda itemComanda);
    public void removerItemComanda(long idComanda,long idProduto);
}
