package com.scrum.restaurante;

import com.scrum.restaurante.domain.ports.repositories.ComandaRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestauranteApplication {


	public static void main(String[] args) {
		SpringApplication.run(RestauranteApplication.class, args);
	}


}
