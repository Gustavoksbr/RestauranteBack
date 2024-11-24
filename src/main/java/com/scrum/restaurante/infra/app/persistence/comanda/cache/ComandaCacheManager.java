package com.scrum.restaurante.infra.app.persistence.comanda.cache;

import com.scrum.restaurante.infra.app.persistence.comanda.JpaComandaRepository;
import com.scrum.restaurante.infra.app.persistence.comanda.entities.ComandaCache;
import com.scrum.restaurante.infra.app.persistence.comanda.entities.ComandaEntity;
import com.scrum.restaurante.infra.config.exception.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ComandaCacheManager {

    @Autowired
    private JpaComandaRepository jpaComandaRepository;

    @Autowired
    private ComandaCacheStore comandaCacheStore;

    public List<ComandaCache> listarComandasDaMesa(Long idMesa) {
        // Verifica se o cache já está preenchido.
        List<ComandaCache> comandas = comandaCacheStore.listarComandasDaMesaCache(idMesa);
        if (comandas.isEmpty()) {
            System.out.println("Cache vazio. Buscando no banco...");
            comandas = jpaComandaRepository.findByIdMesaAndPagaFalse(idMesa)
                    .stream()
                    .map(ComandaCache::new)
                    .peek(comandaCacheStore::salvarComandaCache)
                    .collect(Collectors.toList());
            comandaCacheStore.atualizarComandasDaMesaCache(idMesa, comandas);
        }
        return comandas;
    }

    public void adicionarComanda(Long idMesa) {
        // Cria a nova comanda e salva no banco
        List<ComandaCache> comandas = listarComandasDaMesa(idMesa);
        ComandaEntity novaComanda = new ComandaEntity();
        novaComanda.setIdMesa(idMesa);
        novaComanda = jpaComandaRepository.save(novaComanda);

        // Atualiza o cache com a nova comanda

        if(!comandas.isEmpty()) {
            comandas.add(new ComandaCache(novaComanda));
            comandaCacheStore.atualizarComandasDaMesaCache(idMesa, comandas);
        }

    }

    public void pagarComanda(Long idComanda) {
        // Atualiza o status no banco
        ComandaEntity comandaEntity = jpaComandaRepository.findById(idComanda)
                .orElseThrow(() -> new ResourceNotFoundException("Comanda não encontrada: " + idComanda));
        comandaEntity.setPaga(true);
        jpaComandaRepository.save(comandaEntity);

        // Atualiza o cache
        ComandaCache comandaCache = new ComandaCache(comandaEntity);
        comandaCacheStore.salvarComandaCache(comandaCache);

        // Atualiza a lista de comandas da mesa
        Long idMesa = comandaEntity.getIdMesa();
        List<ComandaCache> comandas = listarComandasDaMesa(idMesa);
        comandas = comandas.stream()
                .filter(c -> c.getId() != idComanda) // Remove a comanda da lista
                .collect(Collectors.toList());
        comandaCacheStore.atualizarComandasDaMesaCache(idMesa, comandas);
    }
//
    public void removerComanda(Long idComanda) {
     ComandaCache comanda = comandaCacheStore.buscarComandaPorId(idComanda)
             .orElseThrow(() -> {
                 if (!this.jpaComandaRepository.existsById(idComanda)) {
                     throw new ResourceNotFoundException("Comanda não encontrada: " + idComanda);
                 }
                 return null;
             });
        comandaCacheStore.removerComandaCache(comanda);
        jpaComandaRepository.delete(comanda.toEntity());


        // Remove do cache
        Long idMesa = comanda.getIdMesa();
        List<ComandaCache> comandas = listarComandasDaMesa(idMesa);
        comandas = comandas.stream()
                .filter(c -> c.getId() != idComanda) // Remove a comanda da lista
                .collect(Collectors.toList());
        comandaCacheStore.atualizarComandasDaMesaCache(idMesa, comandas);
    }
    public List<ComandaCache> listarComandasPagas() {
        List<ComandaCache> comandas = comandaCacheStore.listarComandasPagasCache();
        if (comandas.isEmpty()) {
            System.out.println("Cache vazio. Buscando no banco...");
            comandas = jpaComandaRepository.findAllByPagaTrue()
                    .stream()
                    .map(ComandaCache::new)
                    .collect(Collectors.toList());
            comandaCacheStore.atualizarComandasPagasCache(comandas);
        }
        return comandas;
    }
}