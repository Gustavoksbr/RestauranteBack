package com.scrum.restaurante.domain.ports.manager;

import com.scrum.restaurante.domain.model.Comanda;
import com.scrum.restaurante.domain.model.ItemComanda;

import java.util.List;

public interface ComandaManagerPort {
    public List<ItemComanda> listarItensDaComanda(Long idComanda); // endpoint: GET /comandas/{idComanda}/itens
    public void pagarComanda(Long idComanda); // endpoint: PATCH /comandas/{idComanda}
    public void removerComanda(Long idComanda); // endpoint: DELETE /comandas/{idComanda}
    public void adicionarItemComanda(Long idComanda, ItemComanda itemComanda); // endpoint: POST /comandas/{idComanda}/itens
    public List<Comanda> listarComandasPagas(); // endpoint: GET /comandas/pagas
}
