package com.scrum.restaurante.infra.controllers.itemcomanda;

import com.scrum.restaurante.domain.ports.manager.ItemComandaManagerPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itemcomanda")
public class ItemComandaController {
    @Autowired
    private ItemComandaManagerPort itemComandaManagerPort;
    @DeleteMapping("/{idItemComanda}/{nomeProduto}")
    public void removerItemComanda(@PathVariable long idItemComanda, @PathVariable String nomeProduto) {
        itemComandaManagerPort.removerItemComanda(idItemComanda, nomeProduto);
    }
}
