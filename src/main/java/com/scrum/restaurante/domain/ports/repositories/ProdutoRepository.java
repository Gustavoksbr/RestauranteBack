package com.scrum.restaurante.domain.ports.repositories;

import com.scrum.restaurante.domain.model.Produto;

import java.util.List;

public interface ProdutoRepository {
    public List<Produto> listarProdutos();
}
