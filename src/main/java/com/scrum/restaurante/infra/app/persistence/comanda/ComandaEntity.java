package com.scrum.restaurante.infra.app.persistence.comanda;

import com.scrum.restaurante.domain.model.Comanda;
import jakarta.persistence.*;

@Entity
@Table(name = "comanda")
public class ComandaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     @Column(name = "id_mesa", nullable = false)
     private Long mesaId;
     @Column(name = "pago")
    private boolean paga;
    @Column(name = "total")
    private float valorTotal;
    public Comanda toModel() {
        return new Comanda(this.id, this.mesaId, this.paga, this.valorTotal);
    }
}
