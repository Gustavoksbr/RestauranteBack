package com.scrum.restaurante.infra.app.controllers.comanda.dtos;

import com.scrum.restaurante.domain.model.ItemComanda;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ItemComandaRequest {
    @NotBlank
    private String nomeProduto;
    @Min(1)
    private int quantidade;
    public ItemComanda toModel(){
        return new ItemComanda(nomeProduto, quantidade);
    }
}
