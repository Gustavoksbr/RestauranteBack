package com.scrum.restaurante.infra.app.persistence.itemcomanda;

import com.scrum.restaurante.domain.model.ItemComanda;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Entity
@Table(name = "itemcomanda")
@IdClass(ItemComandaId.class)
public class ItemComandaEntity {
    @Id
    @Column(name = "id_comanda")
    private long idComanda;
    @Id
    @Column(name = "id_produto")
    private long idProduto;
    @Column(name = "nome_produto", nullable = false)
    private String nomeProduto;
    private int quantidade;
    @Column(name = "preco_unitario")
    private float precoUnitario;
    @Column(name = "subtotal")
    private BigDecimal subTotal = null;
    public ItemComandaEntity(ItemComanda itemComanda) {
        this.idComanda = itemComanda.getIdComanda();
        this.idProduto = itemComanda.getIdProduto();
        this.quantidade = itemComanda.getQuantidade();
    }

    public ItemComanda toModel(){
        return new ItemComanda(idComanda, idProduto, nomeProduto, quantidade, precoUnitario, subTotal);
    }
}
