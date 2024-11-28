package com.scrum.restaurante.domain.model.usuario;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse extends AuthResponse {
    private String token;
}