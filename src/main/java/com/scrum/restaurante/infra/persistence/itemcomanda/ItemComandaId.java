package com.scrum.restaurante.infra.persistence.itemcomanda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemComandaId implements Serializable {
    private long idComanda;
    private long idProduto;
}