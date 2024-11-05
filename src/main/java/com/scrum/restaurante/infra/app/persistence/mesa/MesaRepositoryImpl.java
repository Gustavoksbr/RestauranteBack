package com.scrum.restaurante.infra.app.persistence.mesa;

import com.scrum.restaurante.domain.model.Mesa;
import com.scrum.restaurante.domain.ports.repositories.MesaRepositoryPort;
import com.scrum.restaurante.infra.app.persistence.produto.ProdutoEntity;
import com.scrum.restaurante.infra.config.exception.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class MesaRepositoryImpl implements MesaRepositoryPort {
    @Autowired
    private JpaMesaRepository jpaMesaRepository;
    @Override
    public List<Mesa> listarMesas() {
        List<MesaEntity> produtoEntities = this.jpaMesaRepository.findAll();
        return produtoEntities.stream()
                .map(MesaEntity::toModel)
                .toList();
    }

    @Override
    public Mesa buscarMesaPorId(Long idMesa) {
        return this.jpaMesaRepository.findById(idMesa).orElseThrow( ()->new ResourceNotFoundException("Mesa não encontrada com id"+idMesa)).toModel();
    }
}
