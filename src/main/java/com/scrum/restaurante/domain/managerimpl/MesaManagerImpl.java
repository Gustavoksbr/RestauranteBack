package com.scrum.restaurante.domain.managerimpl;

import com.scrum.restaurante.domain.model.Comanda;
import com.scrum.restaurante.domain.model.Mesa;
import com.scrum.restaurante.domain.ports.repositories.ComandaRepositoryPort;
import com.scrum.restaurante.domain.ports.repositories.MesaRepositoryPort;
import com.scrum.restaurante.domain.ports.manager.MesaManagerPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesaManagerImpl implements MesaManagerPort {
    @Autowired
    private MesaRepositoryPort mesaRepositoryPort;
    @Autowired
    private ComandaRepositoryPort comandaRepositoryPort;

    @Override
    public List<Mesa> listarMesas() {
        return this.mesaRepositoryPort.listarMesas();
    }

    @Override
    public List<Comanda> listarComandasNaoPagasPorMesaId(Long idMesa) {
        this.mesaRepositoryPort.buscarMesaPorId(idMesa); //serve pra verificar se a mesa existe
        return this.comandaRepositoryPort.listarComandasDaMesa(idMesa);
    }

    @Override
    public void adicionarComanda(Long idMesa) {
        this.mesaRepositoryPort.buscarMesaPorId(idMesa); //serve pra verificar se a mesa existe
        this.comandaRepositoryPort.adicionarComanda(idMesa);
    }

}
