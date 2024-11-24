package com.scrum.restaurante.infra.app.persistence.comanda.entities;

import com.scrum.restaurante.domain.model.Comanda;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor

public class ComandaCache implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private long idMesa;
    private boolean paga;
    private float precoTotal;

    public ComandaCache(long id, long idMesa, boolean paga, float precoTotal) {
        this.id = id;
        this.idMesa = idMesa;
        this.paga = paga;
        this.precoTotal = precoTotal;
    }

    public ComandaCache(ComandaEntity comandaEntity) {
        this.id = comandaEntity.getId();
        this.idMesa = comandaEntity.getIdMesa();
        this.paga = comandaEntity.isPaga();
        this.precoTotal = comandaEntity.getPrecoTotal();
    }
    public Comanda toModel() {
        return new Comanda(this.id, this.idMesa, this.paga, this.precoTotal);
    }
    public ComandaEntity toEntity() {
        ComandaEntity comandaEntity = new ComandaEntity();
        comandaEntity.setId(this.id);
        comandaEntity.setIdMesa(this.idMesa);
        comandaEntity.setPaga(this.paga);
        comandaEntity.setPrecoTotal(this.precoTotal);
        return comandaEntity;
    }
}

