package com.scrum.restaurante.infra.app.persistence.produto;

import com.scrum.restaurante.domain.model.Produto;
import com.scrum.restaurante.domain.ports.repositories.ProdutoRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdutoRepositoryImpl implements ProdutoRepositoryPort {
    @Override
    public List<Produto> listarProdutos() {
        return List.of();
    }
}
