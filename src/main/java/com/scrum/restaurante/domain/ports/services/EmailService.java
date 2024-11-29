package com.scrum.restaurante.domain.ports.services;

import com.scrum.restaurante.domain.model.email.Email;

public interface EmailService {
    void sendEmail(Email email);
}
