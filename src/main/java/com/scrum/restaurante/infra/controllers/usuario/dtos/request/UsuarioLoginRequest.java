package com.scrum.restaurante.infra.controllers.usuario.dtos.request;

import com.scrum.restaurante.domain.model.usuario.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioLoginRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    public Usuario toDomain() {
        return new Usuario(username, password);
    }

}
