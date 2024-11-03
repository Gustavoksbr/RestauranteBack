package com.scrum.restaurante.domain.ports.repositories;

import com.scrum.restaurante.domain.model.Mesa;

import java.util.List;

public interface MesaRepositoryPort {
    public List<Mesa> listarMesas();
}
