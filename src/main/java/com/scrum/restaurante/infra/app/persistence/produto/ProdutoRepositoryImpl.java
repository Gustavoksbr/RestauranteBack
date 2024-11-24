package com.scrum.restaurante.infra.app.persistence.produto;

import com.scrum.restaurante.domain.model.Produto;
import com.scrum.restaurante.domain.ports.repositories.ProdutoRepositoryPort;
import com.scrum.restaurante.infra.config.exception.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdutoRepositoryImpl implements ProdutoRepositoryPort {
    @Autowired
    private JpaProdutoRepository jpaProdutoRepository;

    private ProdutoEntity entityBuscarProdutoPorNome(String nome) {
        return jpaProdutoRepository.findByNome(nome).orElseThrow(()-> new ResourceNotFoundException("Produto não encontrado com username "+nome));
    }

    @Override
    public List<Produto> listarProdutos() {
   List<ProdutoEntity> produtoEntities = this.jpaProdutoRepository.findAll();
return produtoEntities.stream()
                      .map(ProdutoEntity::toModel)
                      .toList();
    }

    @Override
    public Produto buscarProdutoPorNome(String nome) {
        return this.entityBuscarProdutoPorNome(nome).toModel();
    }
}
