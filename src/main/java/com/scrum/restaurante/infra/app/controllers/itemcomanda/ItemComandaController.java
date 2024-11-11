package com.scrum.restaurante.infra.app.controllers.itemcomanda;

import com.scrum.restaurante.domain.ports.services.ItemComandaServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itemcomanda")
public class ItemComandaController {
    @Autowired
    private ItemComandaServicePort itemComandaServicePort;
    @DeleteMapping("/{idItemComanda}/{nomeProduto}")
    public void removerItemComanda(@PathVariable long idItemComanda, @PathVariable String nomeProduto) {
        itemComandaServicePort.removerItemComanda(idItemComanda, nomeProduto);
    }
}
