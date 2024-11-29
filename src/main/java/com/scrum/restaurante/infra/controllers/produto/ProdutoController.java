package com.scrum.restaurante.infra.controllers.produto;

import com.scrum.restaurante.domain.model.Produto;
import com.scrum.restaurante.domain.ports.manager.ProdutoManagerPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoManagerPort produtoManagerPort;
    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos() {
        return ResponseEntity.ok(this.produtoManagerPort.listarProdutos());
    }
}
