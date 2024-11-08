package com.scrum.restaurante.infra.app.controllers.comanda.dtos;

import com.scrum.restaurante.domain.model.ItemComanda;
import lombok.Data;

import java.math.BigDecimal;

@Data

public class ItemComandaResponse {
    private String nomeProduto;
    private float precoUnitario;
    private int quantidade;
    private BigDecimal precoTotal;

    public ItemComandaResponse(ItemComanda itemComanda) {
        this.nomeProduto = itemComanda.getNomeProduto();
        this.precoUnitario = itemComanda.getPrecoUnitario();
        this.quantidade = itemComanda.getQuantidade();
        this.precoTotal = itemComanda.getPrecoTotal();
    }
}
