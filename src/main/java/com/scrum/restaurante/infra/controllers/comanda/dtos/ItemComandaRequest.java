package com.scrum.restaurante.infra.controllers.comanda.dtos;

import com.scrum.restaurante.domain.model.ItemComanda;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ItemComandaRequest {
    @NotBlank(message = "Não pode ser nulo nem vazio para username")
    private String nomeProduto;
    @Min(value = 1, message = "Tem que colocar no mínimo 1 de quantidade")
    private int quantidade;
    public ItemComanda toModel(){
        return new ItemComanda(nomeProduto, quantidade);
    }
}
