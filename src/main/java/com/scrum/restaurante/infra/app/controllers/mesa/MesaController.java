package com.scrum.restaurante.infra.app.controllers.mesa;

import com.scrum.restaurante.domain.model.Comanda;
import com.scrum.restaurante.domain.model.Mesa;
import com.scrum.restaurante.domain.ports.services.MesaServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}/comanda")
    public ResponseEntity<List<Comanda>> listarComandasDaMesa(@PathVariable long id) {
        List<Comanda> comandas = mesaServicePort.listarComandasNaoPagasPorMesaId(id);
        return ResponseEntity.ok(comandas);
    }

    @PostMapping("{id}/comanda")
    public void adicionarComanda(@PathVariable long id) {
        mesaServicePort.adicionarComanda(id);
    }

}
