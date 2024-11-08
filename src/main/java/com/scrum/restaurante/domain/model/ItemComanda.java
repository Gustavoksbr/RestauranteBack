package com.scrum.restaurante.domain.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ItemComanda {
    private long idComanda;
    private long idProduto;
    private String nomeProduto;
    private int quantidade;
    private float precoUnitario;
    private BigDecimal precoTotal = null; //nulo como valor inicial

    public ItemComanda(String nomeProduto, int quantidade) {
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
    }
}
