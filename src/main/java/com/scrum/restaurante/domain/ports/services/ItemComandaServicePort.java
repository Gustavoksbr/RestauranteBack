package com.scrum.restaurante.domain.ports.services;

public interface ItemComandaServicePort {
    public void removerItemComanda(long idComanda,long idProduto); // endpoint: DELETE /itemcomanda/{id}
}
