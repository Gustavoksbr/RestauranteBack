package com.scrum.restaurante.domain.managerimpl;

import com.scrum.restaurante.domain.model.Produto;
import com.scrum.restaurante.domain.ports.repositories.ProdutoRepositoryPort;
import com.scrum.restaurante.domain.ports.manager.ProdutoManagerPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoManagerImpl implements ProdutoManagerPort {
    @Autowired
    private ProdutoRepositoryPort produtoRepositoryPort;

    @Override
    public List<Produto> listarProdutos() {
        return produtoRepositoryPort.listarProdutos();
    }
}
