package com.scrum.restaurante.domain.services;

import com.scrum.restaurante.domain.model.ItemComanda;
import com.scrum.restaurante.domain.ports.repositories.ComandaRepositoryPort;
import com.scrum.restaurante.domain.ports.services.ComandaServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ComandaServiceImpl implements ComandaServicePort {

    @Autowired
    private ComandaRepositoryPort comandaRepositoryPort;

    @Override
    public List<ItemComanda> listarItensDaComanda(Long idComanda) {
        return List.of();
    }

    @Override
    public void pagarComanda(Long idComanda) {
        this.comandaRepositoryPort.buscarComandaPorId(idComanda); //serve pra verificar se a comanda existe
        this.comandaRepositoryPort.pagarComanda(idComanda);
    }

    @Override
    public void removerComanda(Long idComanda) {
        this.comandaRepositoryPort.buscarComandaPorId(idComanda); //serve pra verificar se a comanda existe
        this.comandaRepositoryPort.removerComanda(idComanda);
    }

    @Override
    public void adicionarItemComanda(Long idComanda, ItemComanda itemComanda) {

    }
}
