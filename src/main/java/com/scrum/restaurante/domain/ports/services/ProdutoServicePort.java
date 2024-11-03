package com.scrum.restaurante.domain.ports.services;

import com.scrum.restaurante.domain.model.Produto;

import java.util.List;

public interface ProdutoServicePort {
    public List<Produto> listarProdutos();// endpoint: GET /produto
}
