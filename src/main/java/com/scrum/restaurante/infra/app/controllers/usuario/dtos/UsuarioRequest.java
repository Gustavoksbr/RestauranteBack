package com.scrum.restaurante.infra.app.controllers.usuario.dtos;

import com.scrum.restaurante.domain.model.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest {
    @NotBlank
    private String username;
    @Email(message = "Email inválido")
    private String email;
    @NotBlank
    private String password;

    public Usuario toDomain() {
        return new Usuario(username, email, password);
    }
}
