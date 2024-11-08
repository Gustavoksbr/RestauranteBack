package com.scrum.restaurante.domain.ports.repositories;

import com.scrum.restaurante.domain.model.Produto;

import java.util.List;

public interface ProdutoRepositoryPort {
    public List<Produto> listarProdutos();
    public Produto buscarProdutoPorNome(String nome);
}
