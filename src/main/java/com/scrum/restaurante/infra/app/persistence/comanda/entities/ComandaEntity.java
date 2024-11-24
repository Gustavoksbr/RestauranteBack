package com.scrum.restaurante.infra.app.persistence.comanda.entities;

import com.scrum.restaurante.domain.model.Comanda;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "comanda")
public class ComandaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     @Column(name = "id_mesa", nullable = false)
     private Long idMesa;
     @Column(name = "pago")
    private boolean paga;
    @Column(name = "total")
    private float precoTotal;

    public Comanda toModel() {
        return new Comanda(this.id, this.idMesa, this.paga, this.precoTotal);
    }
}
