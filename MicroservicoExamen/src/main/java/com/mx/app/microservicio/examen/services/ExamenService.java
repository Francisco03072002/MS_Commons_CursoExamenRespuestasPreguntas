package com.mx.app.microservicio.examen.services;

import java.util.List;

import com.mx.microservicios.commons.examenes.models.entity.Asignatura;
import com.mx.microservicios.commons.examenes.models.entity.Examen;
import com.mx.microservicios.commons.services.CommonService;

public interface ExamenService extends CommonService<Examen> {

	public List<Examen> findByNombre(String term);

	public Iterable<Asignatura> findAllAsignaturas();

	public Iterable<Long> findExamenesIdsConRespuestasByPreguntaIds(Iterable<Long> preguntaIds);

}
