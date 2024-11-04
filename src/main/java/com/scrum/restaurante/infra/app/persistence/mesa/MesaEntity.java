package com.scrum.restaurante.infra.app.persistence.mesa;

import com.scrum.restaurante.domain.model.Mesa;
import jakarta.persistence.*;

@Entity
@Table(name = "mesa")
public class MesaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "quantidade_comanda")
    private int quantidadeComanda;
    public Mesa toModel() {
        return new Mesa(this.id, this.quantidadeComanda);
    }
}
