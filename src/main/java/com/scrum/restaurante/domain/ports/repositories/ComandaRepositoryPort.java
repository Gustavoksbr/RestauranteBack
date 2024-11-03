package com.scrum.restaurante.domain.ports.repositories;

import com.scrum.restaurante.domain.model.Comanda;

import java.util.List;

public interface ComandaRepositoryPort {
    public List<Comanda> listarComandasDaMesa(Long idMesa);
    public void adicionarComanda(Long idMesa);
    public void pagarComanda(Long idComanda);
    public void removerComanda(Long idComanda);
}