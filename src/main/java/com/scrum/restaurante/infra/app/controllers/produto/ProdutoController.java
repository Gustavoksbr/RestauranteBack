package com.scrum.restaurante.infra.app.controllers.produto;

import com.scrum.restaurante.domain.model.Produto;
import com.scrum.restaurante.domain.ports.services.ProdutoServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoServicePort produtoServicePort;
    public List<Produto> listarProdutos() {
        return produtoServicePort.listarProdutos();
    }
}
