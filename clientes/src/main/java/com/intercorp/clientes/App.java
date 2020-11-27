package com.intercorp.clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.intercorp.clientes.repository"})
@EntityScan(basePackages = {"com.intercorp.clientes.model"})
public class App {
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
