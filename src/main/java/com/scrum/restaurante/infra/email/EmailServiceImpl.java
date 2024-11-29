package com.scrum.restaurante.infra.email;

import com.scrum.restaurante.domain.model.email.Email;
import com.scrum.restaurante.domain.ports.services.EmailService;
import com.scrum.restaurante.config.email.MailConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class EmailServiceImpl implements EmailService {
    private static final String FROM_EMAIL = "noreply@emaill.com";
    @Autowired
    private MailConfig mailConfig;
    @Override
public void sendEmail(Email email) {
    CompletableFuture.runAsync(() -> {
        JavaMailSender javaMailSender = this.mailConfig.createMailSender(email.getProvider().toString());
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(FROM_EMAIL);
        message.setTo(email.getTo());
        message.setSubject(email.getSubject());
        message.setText(email.getBody());
        javaMailSender.send(message);
    });
}}

