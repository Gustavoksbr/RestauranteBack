package com.scrum.restaurante.domain.services;

import com.scrum.restaurante.domain.model.Comanda;
import com.scrum.restaurante.domain.model.Mesa;
import com.scrum.restaurante.domain.ports.repositories.ComandaRepositoryPort;
import com.scrum.restaurante.domain.ports.repositories.MesaRepositoryPort;
import com.scrum.restaurante.domain.ports.services.MesaServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesaServiceImpl implements MesaServicePort {
    @Autowired
    private MesaRepositoryPort mesaRepositoryPort;
    @Autowired
    private ComandaRepositoryPort comandaRepositoryPort;

    @Override
    public List<Mesa> listarMesas() {
        return this.mesaRepositoryPort.listarMesas();
    }

    @Override
    public List<Comanda> listarComandasDaMesa(Long idMesa) {
        this.mesaRepositoryPort.buscarMesaPorId(idMesa); //depois implemento exception
        return this.comandaRepositoryPort.listarComandasDaMesa(idMesa);
    }

    @Override
    public void adicionarComanda(Long idMesa) {
        this.mesaRepositoryPort.buscarMesaPorId(idMesa); //depois implemento exception
        this.comandaRepositoryPort.adicionarComanda(idMesa);

    }

}
