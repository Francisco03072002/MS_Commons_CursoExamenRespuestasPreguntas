package com.mx.app.microservicio.examen.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.mx.microservicios.commons.examenes.models.entity.Examen;
import com.mx.microservicios.commons.services.CrudPagingAndSortingRepository;

public interface ExamenRepository extends CrudPagingAndSortingRepository<Examen, Long>{
	

	@Query("select e from Examen e where e.nombre like %?1%")
	public List<Examen> findByNombre(String term);
	
	@Query("select e.id from Pregunta p join p.examen e where p.id in ?1 group by e.id")
	public Iterable<Long> findExamenesIdsConRespuestasByPreguntaIds(Iterable<Long> preguntaIds);


}
