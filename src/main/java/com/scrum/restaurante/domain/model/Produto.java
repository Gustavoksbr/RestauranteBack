package com.scrum.restaurante.domain.model;

import lombok.Data;

@Data
public class Produto {
    private int id;
    private String nome;
    private float preco;
    private Enum<Categoria> categoria;
}
