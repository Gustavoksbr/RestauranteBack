package com.scrum.restaurante.domain.ports.services;

import com.scrum.restaurante.domain.model.Comanda;
import com.scrum.restaurante.domain.model.Mesa;

import java.util.List;

public interface MesaServicePort {
    public List<Mesa> listarMesas(); //endpoint: GET /mesa
    public List<Comanda> listarComandasDaMesa(Long idMesa); //endpoint: GET /mesa/{id}/comanda
    public void adicionarComanda(Long idMesa); //endpoint: POST /mesa/{id}/comanda
}
