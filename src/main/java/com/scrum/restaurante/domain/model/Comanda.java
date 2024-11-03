package com.scrum.restaurante.domain.model;

import lombok.Data;

@Data
public class Comanda {
    private long id;
    private long idMesa;
    private boolean paga;
    private float precoTotal;
}
