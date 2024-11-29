package com.scrum.restaurante.domain.ports.manager;

public interface ItemComandaManagerPort {
    public void removerItemComanda(long idComanda, String nomeProduto); // endpoint: DELETE /itemcomanda/{id}
}
