package com.scrum.restaurante.domain.ports.services;

import com.scrum.restaurante.domain.model.ItemComanda;

import java.util.List;

public interface ComandaServicePort {
    public List<ItemComanda> listarItensDaComanda(Long idComanda); // endpoint: GET /comandas/{idComanda}/itens
    public void pagarComanda(Long idComanda); // endpoint: PATCH /comandas/{idComanda}
    public void removerComanda(Long idComanda); // endpoint: DELETE /comandas/{idComanda}
    public void adicionarItemComanda(Long idComanda, ItemComanda itemComanda); // endpoint: POST /comandas/{idComanda}/itens
}
