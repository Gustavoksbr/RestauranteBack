package com.scrum.restaurante.infra.app.persistence.comanda;

import com.scrum.restaurante.domain.model.Comanda;
import com.scrum.restaurante.domain.ports.repositories.ComandaRepositoryPort;
import com.scrum.restaurante.infra.app.persistence.comanda.cache.ComandaCacheManager;
import com.scrum.restaurante.infra.app.persistence.comanda.entities.ComandaCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ComandaRepositoryImpl implements ComandaRepositoryPort {

    @Autowired
    private JpaComandaRepository jpaComandaRepository;

    @Autowired
    private ComandaCacheManager comandaCacheManager;

    @Override
    public List<Comanda> listarComandasDaMesa(Long idMesa) {
        // Consulta o ComandaCacheManager, que gerencia cache e banco.
        return comandaCacheManager.listarComandasDaMesa(idMesa)
                .stream()
                .map(ComandaCache::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Comanda buscarComandaPorId(Long idComanda) {
        return null;
    }

    @Override
    public void adicionarComanda(Long idMesa) {
        // Delegar a lógica de adicionar comanda para o ComandaCacheManager.
        comandaCacheManager.adicionarComanda(idMesa);
    }

    @Override
    public void pagarComanda(Long idComanda) {
        // Delegar a lógica de pagar comanda para o ComandaCacheManager.
        comandaCacheManager.pagarComanda(idComanda);
    }

    @Override
    public void removerComanda(Long idComanda) {
        // Delegar a lógica de remover comanda para o ComandaCacheManager.
        comandaCacheManager.removerComanda(idComanda);
    }

    @Override
    public List<Comanda> listarComandasPagas() {
        // As comandas pagas podem ser gerenciadas pelo ComandaCacheManager.
        return comandaCacheManager.listarComandasPagas()
                .stream()
                .map(ComandaCache::toModel)
                .collect(Collectors.toList());
    }
}
