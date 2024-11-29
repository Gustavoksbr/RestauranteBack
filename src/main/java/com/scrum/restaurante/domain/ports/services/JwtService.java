package com.scrum.restaurante.domain.ports.services;

public interface JwtService {
    String generateToken(String subject);
    String getUsername(String token);
}