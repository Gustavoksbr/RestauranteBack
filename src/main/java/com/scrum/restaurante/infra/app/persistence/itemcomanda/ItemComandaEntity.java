package com.scrum.restaurante.infra.app.persistence.itemcomanda;

import com.scrum.restaurante.domain.model.ItemComanda;
import jakarta.persistence.*;


@Entity
@Table(name = "itemcomanda")
public class ItemComandaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "id_comanda", nullable = false)
    private long idComanda;
    @Column(name = "id_produto", nullable = false)
    private long idProduto;
    @Column(name = "nome_produto", nullable = false)
    private String nomeProduto;
    private int quantidade;
    @Column(name = "preco_unitario")
    private float precoUnitario;
    @Column(name = "subtotal")
    private float precoTotal;
    public ItemComanda toModel(){
        return new ItemComanda(id, idComanda, idProduto, nomeProduto, quantidade, precoUnitario, precoTotal);
    }
}
