package com.mx.app.microservicio.examen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.app.microservicio.examen.models.repository.AsignaturaRepository;
import com.mx.app.microservicio.examen.models.repository.ExamenRepository;
import com.mx.microservicios.commons.examenes.models.entity.Asignatura;
import com.mx.microservicios.commons.examenes.models.entity.Examen;
import com.mx.microservicios.commons.services.CommonServiceImpl;

@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, ExamenRepository> implements ExamenService  {

	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Examen> findByNombre(String term) {
		return repository.findByNombre(term);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Asignatura> findAllAsignaturas() {
		return asignaturaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Long> findExamenesIdsConRespuestasByPreguntaIds(Iterable<Long> preguntaIds) {
		return repository.findExamenesIdsConRespuestasByPreguntaIds(preguntaIds);
	}

	
}
