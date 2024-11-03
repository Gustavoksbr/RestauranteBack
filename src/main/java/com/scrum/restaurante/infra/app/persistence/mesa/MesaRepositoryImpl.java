package com.scrum.restaurante.infra.app.persistence.mesa;

import com.scrum.restaurante.domain.model.Mesa;
import com.scrum.restaurante.domain.ports.repositories.MesaRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class MesaRepositoryImpl implements MesaRepositoryPort {
    @Override
    public List<Mesa> listarMesas() {
        return List.of();
    }
}
