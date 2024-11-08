package com.scrum.restaurante.infra.app.controllers.itemcomanda;

import com.scrum.restaurante.domain.ports.services.ItemComandaServicePort;
import com.scrum.restaurante.infra.app.controllers.itemcomanda.dtos.ItemComandaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/itemcomanda")
public class ItemComandaController {
    @Autowired
    private ItemComandaServicePort itemComandaServicePort;
    public void removerItemComanda(Long idItemComanda) {
        itemComandaServicePort.removerItemComanda(idItemComanda);
    }
}
