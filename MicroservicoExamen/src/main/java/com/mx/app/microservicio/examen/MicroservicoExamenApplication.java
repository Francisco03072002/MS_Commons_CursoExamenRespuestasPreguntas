package com.mx.app.microservicio.examen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@EntityScan({"com.formacionbdi.microservicios.commons.examenes.models.entity"})

public class MicroservicoExamenApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicoExamenApplication.class, args);
	}

}
