package com.scrum.restaurante.infra.app.persistence.comanda;

import com.scrum.restaurante.domain.model.Comanda;
import com.scrum.restaurante.domain.ports.repositories.ComandaRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComandaRepositoryImpl implements ComandaRepositoryPort {
    @Override
    public List<Comanda> listarComandasDaMesa(Long idMesa) {
        return List.of();
    }

    @Override
    public void adicionarComanda(Long idMesa) {

    }

    @Override
    public void pagarComanda(Long idComanda) {

    }

    @Override
    public void removerComanda(Long idComanda) {

    }
}
