package com.scrum.restaurante.domain.ports.manager;

import com.scrum.restaurante.domain.model.Produto;

import java.util.List;

public interface ProdutoManagerPort {
    public List<Produto> listarProdutos();// endpoint: GET /produto
}
