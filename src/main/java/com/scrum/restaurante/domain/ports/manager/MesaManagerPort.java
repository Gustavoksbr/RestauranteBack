package com.scrum.restaurante.domain.ports.manager;

import com.scrum.restaurante.domain.model.Comanda;
import com.scrum.restaurante.domain.model.Mesa;

import java.util.List;

public interface MesaManagerPort {
    public List<Mesa> listarMesas(); //endpoint: GET /mesa
    public List<Comanda> listarComandasNaoPagasPorMesaId(Long idMesa); //endpoint: GET /mesa/{id}/comanda
    public void adicionarComanda(Long idMesa); //endpoint: POST /mesa/{id}/comanda
}
