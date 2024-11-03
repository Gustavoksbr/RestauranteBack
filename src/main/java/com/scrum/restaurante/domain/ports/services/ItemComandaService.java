package com.scrum.restaurante.domain.ports.services;

import com.scrum.restaurante.domain.model.ItemComanda;

import java.util.List;

public interface ItemComandaService {
    public void removerItemComanda(); // endpoint: DELETE /itemcomanda/{id}
}
