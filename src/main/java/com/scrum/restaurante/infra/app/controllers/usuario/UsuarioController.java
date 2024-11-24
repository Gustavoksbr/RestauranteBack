package com.scrum.restaurante.infra.app.controllers.usuario;


import com.scrum.restaurante.domain.model.Jwt;
import com.scrum.restaurante.domain.model.Usuario;
import com.scrum.restaurante.domain.ports.services.UsuarioManager;
import com.scrum.restaurante.infra.app.controllers.usuario.dtos.UsuarioRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UsuarioController {

   @Autowired
   private UsuarioManager usuarioServiceManager;
   @PostMapping("/cadastro")
   public ResponseEntity<Jwt> createUser(@RequestBody @Valid UsuarioRequest usuario) {
      Jwt jwt = new Jwt(usuarioServiceManager.createUser(usuario.toDomain()));
      return ResponseEntity.ok(jwt);
   }
   }

