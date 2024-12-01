package com.scrum.restaurante;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestauranteApplication {


	public static void main(String[] args) {

		Dotenv.configure()
				.directory("src/main/resources")
				.ignoreIfMalformed()
				.ignoreIfMissing()
				.load();

		SpringApplication.run(RestauranteApplication.class, args);

	}

}
