package com.scrum.restaurante.domain.managerimpl;

import com.scrum.restaurante.domain.ports.repositories.ItemComandaRepositoryPort;
import com.scrum.restaurante.domain.ports.manager.ItemComandaManagerPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemComandaManagerImpl implements ItemComandaManagerPort {
    @Autowired
    private ItemComandaRepositoryPort itemComandaRepositoryPort;
    @Override
    public void removerItemComanda(long idComanda, String nomeProduto) {

        this.itemComandaRepositoryPort.removerItemComanda(idComanda,nomeProduto);
    }
}
