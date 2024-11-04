package com.scrum.restaurante.infra.app.persistence.produto;

import com.scrum.restaurante.domain.model.Produto;
import com.scrum.restaurante.domain.ports.repositories.ProdutoRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdutoRepositoryImpl implements ProdutoRepositoryPort {
    @Autowired
    private JpaProdutoRepository jpaProdutoRepository;

    @Override
    public List<Produto> listarProdutos() {
   List<ProdutoEntity> produtoEntities = this.jpaProdutoRepository.findAll();
return produtoEntities.stream()
                      .map(ProdutoEntity::toModel)
                      .toList();
    }
}
