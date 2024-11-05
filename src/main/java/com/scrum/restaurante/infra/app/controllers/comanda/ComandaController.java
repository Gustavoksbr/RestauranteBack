package com.scrum.restaurante.infra.app.controllers.comanda;

import com.scrum.restaurante.domain.ports.services.ComandaServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comanda")
public class ComandaController {
    @Autowired
    private ComandaServicePort comandaServicePort;

    @DeleteMapping("/{idComanda}")
    public void removerComanda(@PathVariable long idComanda) {
        comandaServicePort.removerComanda(idComanda);
    }

    @PatchMapping("/{idComanda}")
    public void pagarComanda(@PathVariable long idComanda) {
        comandaServicePort.pagarComanda(idComanda);
    }
}
