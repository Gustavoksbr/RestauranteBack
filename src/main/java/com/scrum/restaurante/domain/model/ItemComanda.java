package com.scrum.restaurante.domain.model;

import lombok.Data;

@Data
public class ItemComanda {
    private long id;
    private long idComanda;
    private long idProduto;
    private String nomeProduto;
    private int quantidade;
    private float precoUnitario;
    private float precoTotal;
}
