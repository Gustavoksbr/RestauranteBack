package com.scrum.restaurante.infra.controllers.comanda;

import com.scrum.restaurante.domain.model.ItemComanda;
import com.scrum.restaurante.domain.ports.manager.ComandaManagerPort;
import com.scrum.restaurante.infra.controllers.comanda.dtos.ItemComandaRequest;
import com.scrum.restaurante.infra.controllers.comanda.dtos.ItemComandaResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comanda")
public class ComandaController {
    @Autowired
    private ComandaManagerPort comandaManagerPort;

    @DeleteMapping("/{idComanda}")
    public void removerComanda(@PathVariable long idComanda) {
        comandaManagerPort.removerComanda(idComanda);
    }

    @PatchMapping("/{idComanda}")
    public void pagarComanda(@PathVariable long idComanda) {
        comandaManagerPort.pagarComanda(idComanda);
    }
    @GetMapping("/{idComanda}/itemcomanda")
    public ResponseEntity<List<ItemComandaResponse>> listarItensComanda(@PathVariable long idComanda) {
        List<ItemComanda> lista = comandaManagerPort.listarItensDaComanda(idComanda);
        List<ItemComandaResponse> listaResponse = lista.stream().map(ItemComandaResponse::new).toList();
        return ResponseEntity.ok(listaResponse);
    }
    @PostMapping("/{idComanda}/itemcomanda")
    public void adicionarItemComanda(@PathVariable long idComanda, @RequestBody @Valid ItemComandaRequest itemComandaRequest) {
        ItemComanda itemComanda = itemComandaRequest.toModel();
        comandaManagerPort.adicionarItemComanda(idComanda, itemComanda);
    }
//    @GetMapping("/pagas")
//    public ResponseEntity<List<Comanda>> listarComandasPagas() {
//        List<Comanda> lista = comandaManagerPort.listarComandasPagas();
//        List<ItemComandaResponse> listaResponse = lista.stream().map(ItemComandaResponse::new).toList();
//        return ResponseEntity.ok(listaResponse);
//    }
}
