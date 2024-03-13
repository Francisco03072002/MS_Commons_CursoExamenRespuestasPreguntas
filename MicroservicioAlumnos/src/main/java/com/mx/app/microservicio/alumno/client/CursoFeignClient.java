package com.mx.app.microservicio.alumno.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Microservicio-Cursos")
public interface CursoFeignClient {

	@DeleteMapping("/eliminar-alumno/{id}")
	public void eliminarCursoAlumnoPorId(@PathVariable Long id);

}
