package com.scrum.restaurante.infra.app.persistence.comanda;

import com.scrum.restaurante.domain.model.Comanda;
import com.scrum.restaurante.domain.ports.repositories.ComandaRepositoryPort;
import com.scrum.restaurante.infra.config.exception.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComandaRepositoryImpl implements ComandaRepositoryPort {
    @Autowired
    private JpaComandaRepository JpacomandaRepository;

    @Override
    public List<Comanda> listarComandasDaMesa(Long idMesa) {
       return this.JpacomandaRepository.findByMesaId(idMesa).
               stream().
               map(ComandaEntity::toModel).
               toList();
    }

    @Override
    public Comanda buscarComandaPorId(Long idComanda) {
        return this.JpacomandaRepository.findById(idComanda).orElseThrow(()->new ResourceNotFoundException("Comanda não encontrada com id"+idComanda)).toModel();
    }

    @Override
    public void adicionarComanda(Long idMesa) {
        ComandaEntity comandaEntity = new ComandaEntity();
        comandaEntity.setMesaId(idMesa);
        this.JpacomandaRepository.save(comandaEntity);
    }

    @Override
    public void pagarComanda(Long idComanda) {
    }

    @Override
    public void removerComanda(Long idComanda) {
        this.JpacomandaRepository.deleteById(idComanda);
    }
}
