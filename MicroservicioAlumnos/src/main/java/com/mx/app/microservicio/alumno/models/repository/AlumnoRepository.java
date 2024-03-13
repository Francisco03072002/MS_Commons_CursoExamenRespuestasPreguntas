package com.mx.app.microservicio.alumno.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.mx.commons.microservicio.alumno.models.entity.Alumno;
import com.mx.microservicios.commons.services.CrudPagingAndSortingRepository;

public interface AlumnoRepository extends CrudPagingAndSortingRepository<Alumno, Long>{

	@Query("select a from Alumno a where upper(a.nombre) like upper(concat('%', ?1, '%')) or upper(a.apellido) like upper(concat('%', ?1, '%'))")
	public List<Alumno> findByNombreOrApellido(String term);

}
