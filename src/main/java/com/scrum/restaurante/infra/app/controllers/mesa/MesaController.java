package com.scrum.restaurante.infra.app.controllers.mesa;

import com.scrum.restaurante.domain.model.Mesa;
import com.scrum.restaurante.domain.ports.services.MesaServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/mesa")
public class MesaController {
    @Autowired
    private MesaServicePort mesaServicePort;
    @GetMapping
    public ResponseEntity<List<Mesa>> listarMesas() {
        List<Mesa> mesas = mesaServicePort.listarMesas();
        return ResponseEntity.ok(mesas);
    }
    @PostMapping("/idMesa/comanda")
    public void adicionarComanda(long idMesa) {
        mesaServicePort.adicionarComanda(idMesa);
    }
}
