package com.scrum.restaurante.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Mesa {
    private long id;
    private int quantidadeComanda;
}
