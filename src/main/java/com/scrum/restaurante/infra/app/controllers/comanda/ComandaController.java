package com.scrum.restaurante.infra.app.controllers.comanda;

import com.scrum.restaurante.domain.model.Comanda;
import com.scrum.restaurante.domain.model.ItemComanda;
import com.scrum.restaurante.domain.ports.services.ComandaServicePort;
import com.scrum.restaurante.infra.app.controllers.comanda.dtos.ItemComandaRequest;
import com.scrum.restaurante.infra.app.controllers.comanda.dtos.ItemComandaResponse;
import jakarta.validation.Valid;
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
    @GetMapping("/{idComanda}/itemcomanda")
    public ResponseEntity<List<ItemComandaResponse>> listarItensComanda(@PathVariable long idComanda) {
        List<ItemComanda> lista = comandaServicePort.listarItensDaComanda(idComanda);
        List<ItemComandaResponse> listaResponse = lista.stream().map(ItemComandaResponse::new).toList();
        return ResponseEntity.ok(listaResponse);
    }
    @PostMapping("/{idComanda}/itemcomanda")
    public void adicionarItemComanda(@PathVariable long idComanda, @RequestBody @Valid ItemComandaRequest itemComandaRequest) {
        ItemComanda itemComanda = itemComandaRequest.toModel();
        comandaServicePort.adicionarItemComanda(idComanda, itemComanda);
    }
    @GetMapping("/pagas")
    public ResponseEntity<List<Comanda>> listarComandasPagas() {
        List<Comanda> lista = comandaServicePort.listarComandasPagas();
        List<ItemComandaResponse> listaResponse = lista.stream().map(ComandaResponse::new).toList();
        return ResponseEntity.ok(listaResponse);
    }
}
