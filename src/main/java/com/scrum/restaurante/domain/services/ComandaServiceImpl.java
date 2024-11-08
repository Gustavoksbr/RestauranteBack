package com.scrum.restaurante.domain.services;

import com.scrum.restaurante.domain.model.ItemComanda;
import com.scrum.restaurante.domain.ports.repositories.ComandaRepositoryPort;
import com.scrum.restaurante.domain.ports.repositories.ItemComandaRepositoryPort;
import com.scrum.restaurante.domain.ports.services.ComandaServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ComandaServiceImpl implements ComandaServicePort {

    @Autowired
    private ComandaRepositoryPort comandaRepositoryPort;

    @Autowired
    private ItemComandaRepositoryPort itemComandaRepositoryPort;

    @Override
    public List<ItemComanda> listarItensDaComanda(Long idComanda) {
        comandaRepositoryPort.buscarComandaPorId(idComanda); //serve pra verificar se a comanda existe
        return this.itemComandaRepositoryPort.listarItensDaComanda(idComanda);
    }

    @Override
    public void pagarComanda(Long idComanda) {
        this.comandaRepositoryPort.pagarComanda(idComanda);
    }

    @Override
    public void removerComanda(Long idComanda) {
        this.comandaRepositoryPort.removerComanda(idComanda);
    }

    @Override
    public void adicionarItemComanda(Long idComanda, ItemComanda itemComanda) {

    }
}
