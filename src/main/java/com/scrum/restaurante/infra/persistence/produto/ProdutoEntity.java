package com.scrum.restaurante.infra.persistence.produto;

import com.scrum.restaurante.domain.model.Categoria;
import com.scrum.restaurante.domain.model.Produto;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "produto")
public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username",unique = true, nullable = false)
    private String nome;
    @Column(name = "preco", nullable = false)
    private float preco;
    @Column(name = "categoria", nullable = false)
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    public Produto toModel() {
        return new Produto(this.id, this.nome, this.preco, this.categoria);
    }
}
