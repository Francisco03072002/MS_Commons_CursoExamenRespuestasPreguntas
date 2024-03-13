package com.mx.app.microservicio.curso.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mx.commons.microservicio.alumno.models.entity.Alumno;

@FeignClient(name = "Microservicio-Alumnos")
public interface AlumnoFeignClient {
	
	@GetMapping("/alumnos-por-curso")
	public Iterable<Alumno> obtenerAlumnosPorCurso(@RequestParam Iterable<Long> ids);

}
