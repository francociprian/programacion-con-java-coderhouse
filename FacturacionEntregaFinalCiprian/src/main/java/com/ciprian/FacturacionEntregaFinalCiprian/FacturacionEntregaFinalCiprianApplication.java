package com.ciprian.FacturacionEntregaFinalCiprian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
public class FacturacionEntregaFinalCiprianApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacturacionEntregaFinalCiprianApplication.class, args);
	}

	@Bean
	public OpenAPI apiDocConfig() {
		return new OpenAPI()
		.info(new Info()
			.title("Proyecto Facturacion API")
			.description("Proyecto Facturacion para el curso Programacion con Java - Coderhouse")
			.version("0.0.1")
			.contact(new Contact()
				.name("Franco Ciprian")
				.url("https://www.francociprian.com.ar/")
			)
		);
	}
}
