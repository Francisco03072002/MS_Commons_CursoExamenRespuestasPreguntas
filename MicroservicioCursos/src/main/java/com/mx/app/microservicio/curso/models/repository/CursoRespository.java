package com.mx.app.microservicio.curso.models.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.mx.app.microservicio.curso.models.entity.Curso;
import com.mx.microservicios.commons.services.CrudPagingAndSortingRepository;

public interface CursoRespository extends CrudPagingAndSortingRepository<Curso, Long>{
	
	@Query("select c from Curso c join fetch c.cursoAlumnos a where a.alumnoId=?1")
	public Curso findCursoByAlumnoId(Long id);
	
	@Modifying
	@Query("delete from CursoAlumno ca where ca.alumnoId=?1")
	public void eliminarCursoAlumnoPorId(Long id);

}
