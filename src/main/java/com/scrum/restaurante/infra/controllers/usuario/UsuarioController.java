package com.scrum.restaurante.infra.controllers.usuario;


import com.scrum.restaurante.domain.model.Jwt;
import com.scrum.restaurante.domain.model.usuario.AuthResponse;
import com.scrum.restaurante.domain.model.usuario.JwtResponse;
import com.scrum.restaurante.domain.model.usuario.Usuario;
import com.scrum.restaurante.domain.ports.manager.UsuarioManager;
import com.scrum.restaurante.infra.controllers.usuario.dtos.request.DoisFatoresRequest;
import com.scrum.restaurante.infra.controllers.usuario.dtos.request.NomeRequest;
import com.scrum.restaurante.infra.controllers.usuario.dtos.request.UsuarioCadastroRequest;
import com.scrum.restaurante.infra.controllers.usuario.dtos.request.UsuarioLoginRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UsuarioController {

   @Autowired
   private UsuarioManager usuarioServiceManager;
   @PostMapping("/cadastro")
   public ResponseEntity<Jwt> createUser(@RequestBody @Valid UsuarioCadastroRequest usuario) {
      Jwt jwt = new Jwt(usuarioServiceManager.createUser(usuario.toDomain()));
      return ResponseEntity.ok(jwt);
   }
   @PostMapping("/login")
   public ResponseEntity<AuthResponse> authenticate(  @RequestBody @Valid UsuarioLoginRequest usuario){
      AuthResponse authResponse = usuarioServiceManager.authenticate(usuario.toDomain());
      return ResponseEntity.ok(authResponse);
   }

   @PutMapping("usuario/nome")
    public ResponseEntity<String> mudarNome(@RequestBody @Valid  NomeRequest nomeRequest, @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(usuarioServiceManager.mudarNome(nomeRequest.getNome(), token));
    }
   @PutMapping("/usuario/doisfatores")
   public ResponseEntity<Boolean> doisFatores(@RequestHeader("Authorization") String token) {
      return ResponseEntity.ok(usuarioServiceManager.habilitarDesabilitarDoisFatores(token));
   }
   @PostMapping("/login2fa")
   public ResponseEntity<JwtResponse> authenticate2fa(@RequestBody @Valid DoisFatoresRequest doisFatoresRequest){
      Usuario usuario = new Usuario(doisFatoresRequest.getUsername(), doisFatoresRequest.getPassword());
      JwtResponse jwtResponse = new JwtResponse(usuarioServiceManager.authenticate2fa(usuario, doisFatoresRequest.getCodigo()));
      return ResponseEntity.ok(jwtResponse);

   }
}

