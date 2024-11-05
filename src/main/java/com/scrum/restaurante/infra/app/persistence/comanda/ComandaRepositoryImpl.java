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

    private ComandaEntity entityBuscarPorId(Long idComanda) {
        return this.JpacomandaRepository.findById(idComanda).orElseThrow(()->new ResourceNotFoundException("Comanda não encontrada com id"+idComanda));
    }

    //implementacao dos metodos da interface

    @Override
    public List<Comanda> listarComandasDaMesa(Long idMesa) {
       return this.JpacomandaRepository.findByMesaIdAndPagaFalse(idMesa).
               stream().
               map(ComandaEntity::toModel).
               toList();
    }

    @Override
    public Comanda buscarComandaPorId(Long idComanda) {
        return this.entityBuscarPorId(idComanda).toModel();
    }

    @Override
    public void adicionarComanda(Long idMesa) {
        ComandaEntity comandaEntity = new ComandaEntity();
        comandaEntity.setMesaId(idMesa);
        this.JpacomandaRepository.save(comandaEntity);
    }

    @Override
    public void pagarComanda(Long idComanda) {
        ComandaEntity comandaEntity = entityBuscarPorId(idComanda); //serve para verificar se a comanda existe
        comandaEntity.setPaga(true); //seta a comanda como paga
        this.JpacomandaRepository.save(comandaEntity);
    }

    @Override
    public void removerComanda(Long idComanda) {
        entityBuscarPorId(idComanda); //serve para verificar se a comanda existe
        this.JpacomandaRepository.deleteById(idComanda);
    }
}
