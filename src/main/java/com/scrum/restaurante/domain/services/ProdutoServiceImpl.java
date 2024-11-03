package com.scrum.restaurante.domain.services;

import com.scrum.restaurante.domain.model.Produto;
import com.scrum.restaurante.domain.ports.repositories.ProdutoRepositoryPort;
import com.scrum.restaurante.domain.ports.services.ProdutoServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoServicePort {
    @Autowired
    private ProdutoRepositoryPort produtoRepositoryPort;

    @Override
    public List<Produto> listarProdutos() {
        return produtoRepositoryPort.listarProdutos();
    }
}
