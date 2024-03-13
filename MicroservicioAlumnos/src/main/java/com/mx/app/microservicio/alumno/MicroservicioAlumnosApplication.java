package com.mx.app.microservicio.alumno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EntityScan({"com.mx.commons.microservicio.alumno.models.entity"})
public class MicroservicioAlumnosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioAlumnosApplication.class, args);
	}

}
