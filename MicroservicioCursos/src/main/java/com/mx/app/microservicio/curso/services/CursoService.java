package com.mx.app.microservicio.curso.services;

import com.mx.app.microservicio.curso.models.entity.Curso;
import com.mx.commons.microservicio.alumno.models.entity.Alumno;
import com.mx.microservicios.commons.services.CommonService;

public interface CursoService extends CommonService<Curso>{
	
	public Curso findCursoByAlumnoId(Long id);
	
	public Iterable<Long> obtenerExamenesIdsConRespuestasAlumno(Long alumnoId);
	
	public Iterable<Alumno> obtenerAlumnosPorCurso(Iterable<Long> ids);
	
	public void eliminarCursoAlumnoPorId(Long id);

}
