package com.mx.app.microservicio.examen.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.mx.microservicios.commons.examenes.models.entity.Asignatura;

public interface AsignaturaRepository  extends CrudRepository<Asignatura, Long>  {

}
