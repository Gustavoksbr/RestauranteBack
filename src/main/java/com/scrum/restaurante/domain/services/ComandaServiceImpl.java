package com.scrum.restaurante.domain.services;

import com.scrum.restaurante.domain.model.ItemComanda;
import com.scrum.restaurante.domain.ports.services.ComandaServicePort;

import java.util.List;

public class ComandaServiceImpl implements ComandaServicePort {

    @Override
    public List<ItemComanda> listarItensDaComanda(Long idComanda) {
        return List.of();
    }

    @Override
    public void pagarComanda(Long idComanda) {

    }

    @Override
    public void removerComanda(Long idComanda) {

    }

    @Override
    public void adicionarItemComanda(Long idComanda, ItemComanda itemComanda) {

    }
}
