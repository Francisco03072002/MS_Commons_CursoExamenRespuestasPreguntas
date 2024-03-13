package com.mx.app.microservicio.respuesta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MicroservicoRespuestasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicoRespuestasApplication.class, args);
	}

}
