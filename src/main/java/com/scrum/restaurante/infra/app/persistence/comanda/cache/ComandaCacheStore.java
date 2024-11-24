package com.scrum.restaurante.infra.app.persistence.comanda.cache;

import com.scrum.restaurante.infra.app.persistence.comanda.entities.ComandaCache;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ComandaCacheStore {

    //mesa
    @Cacheable(value = "comandasPorMesa", key = "#idMesa")
    public List<ComandaCache> listarComandasDaMesaCache(Long idMesa) {
        // Retorno inicial vazio; será preenchido na implementação real do cache.
        System.out.println("Listando comandas da mesa " + idMesa);
        return new ArrayList<>();
    }

    @CachePut(value = "comandasPorMesa", key = "#idMesa")
    public List<ComandaCache> atualizarComandasDaMesaCache(Long idMesa, List<ComandaCache> comandas) {
        System.out.println("Atualizando cache de comandas da mesa " + idMesa);
        return comandas;
    }

    //pagas
    @Cacheable(value = "comandasPagas")
    public List<ComandaCache> listarComandasPagasCache() {
        // Retorno inicial vazio; será preenchido na implementação real do cache.
        System.out.println("Listando comandas pagas");
        return new ArrayList<>();
    }
    @CachePut(value = "comandasPagas")
    public List<ComandaCache> atualizarComandasPagasCache(List<ComandaCache> comandas) {
        System.out.println("Atualizando cache de comandas pagas");
        return comandas;
    }


    //comanda
    @Cacheable(value = "comanda", key = "#idComanda", unless = "#result == null || #result.isEmpty()")
    public Optional<ComandaCache> buscarComandaPorId(Long idComanda) {
        System.out.println("Buscando comanda " + idComanda);
        return Optional.empty(); // Representa o retorno do cache, ou null caso não exista.
    }

    @CachePut(value = "comanda", key = "#comandaCache.id")
    public ComandaCache salvarComandaCache(ComandaCache comandaCache) {
        System.out.println("Salvando comanda " + comandaCache.getId());
        return comandaCache;
    }
    @CacheEvict(value = "comanda", key = "#comandaCache.id")
    public void removerComandaCache(ComandaCache comandaCache) {
        System.out.println("Removendo comanda " + comandaCache.getId());
    }

}

