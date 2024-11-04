package com.scrum.restaurante.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Produto {
    private long id;
    private String nome;
    private float preco;
    private Enum<Categoria> categoria;
}
