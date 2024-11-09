package com.scrum.restaurante.domain.services;

import com.scrum.restaurante.domain.ports.repositories.ItemComandaRepositoryPort;
import com.scrum.restaurante.domain.ports.services.ItemComandaServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemComandaServiceImpl implements ItemComandaServicePort {
    @Autowired
    private ItemComandaRepositoryPort itemComandaRepositoryPort;
    @Override
    public void removerItemComanda(long idComanda, long idProduto) {

        this.itemComandaRepositoryPort.removerItemComanda(idComanda,idProduto);
    }
}
