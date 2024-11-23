package com.scrum.restaurante.infra.app.controllers.usuario;


import com.scrum.restaurante.domain.ports.services.UsuarioManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UsuarioController {

   @Autowired
   private UsuarioManager usuarioServiceManager;

   }

