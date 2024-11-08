package com.scrum.restaurante.infra.app.controllers.comanda;

import com.scrum.restaurante.domain.model.ItemComanda;
import com.scrum.restaurante.domain.ports.services.ComandaServicePort;
import com.scrum.restaurante.infra.app.controllers.itemcomanda.dtos.ItemComandaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/{id}/itemcomanda")
    public ResponseEntity<List<ItemComandaResponse>> listarItensComanda(@PathVariable long id) {
        List<ItemComanda> lista = comandaServicePort.listarItensDaComanda(id);
        List<ItemComandaResponse> listaResponse = lista.stream().map(ItemComandaResponse::new).toList();
        return ResponseEntity.ok(listaResponse);
    }
}
