package com.scrum.restaurante.infra.app.persistence.comanda;

import com.scrum.restaurante.domain.model.Comanda;
import com.scrum.restaurante.domain.ports.repositories.ComandaRepositoryPort;
import com.scrum.restaurante.domain.ports.repositories.MesaRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComandaRepositoryImpl implements ComandaRepositoryPort {
    @Autowired
    private JpaComandaRepository JpacomandaRepository;
    @Autowired
    private MesaRepositoryPort mesaRepositoryPort;
    @Override
    public List<Comanda> listarComandasDaMesa(Long idMesa) {
       return this.JpacomandaRepository.findByMesaId(idMesa).
               stream().
               map(ComandaEntity::toModel).
               toList();
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
