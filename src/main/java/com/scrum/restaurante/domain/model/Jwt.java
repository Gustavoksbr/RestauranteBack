package com.scrum.restaurante.domain.model;

import com.scrum.restaurante.domain.model.usuario.AuthResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Jwt extends AuthResponse {

    private String token;


}