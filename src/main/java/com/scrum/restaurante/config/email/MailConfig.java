package com.scrum.restaurante.config.email;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {

    private Dotenv dotenv = Dotenv.load();

    public JavaMailSender createMailSender(String provider) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        provider = provider.toUpperCase();
        mailSender.setHost(dotenv.get(provider+"_HOST"));
        mailSender.setPort(Integer.parseInt(dotenv.get(provider+"_PORT")));
        mailSender.setUsername(dotenv.get(provider+"_USERNAME"));
        mailSender.setPassword(dotenv.get(provider+"_PASSWORD"));

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}