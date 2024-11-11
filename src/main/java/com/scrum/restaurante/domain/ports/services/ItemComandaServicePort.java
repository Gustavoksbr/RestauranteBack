package com.scrum.restaurante.domain.ports.services;

public interface ItemComandaServicePort {
    public void removerItemComanda(long idComanda, String nomeProduto); // endpoint: DELETE /itemcomanda/{id}
}
