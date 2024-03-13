package com.mx.app.microservicio.curso.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cursos_alumnos")
public class CursoAlumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="alumno_id", unique = true)
	private Long alumnoId;
	
	@JsonIgnoreProperties(value= {"cursoAlumnos"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="curso_id")
	private Curso curso;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAlumnoId() {
		return alumnoId;
	}

	public void setAlumnoId(Long alumnoId) {
		this.alumnoId = alumnoId;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public boolean equals(Object obj) {

		if(this == obj) {
			return true;
		}
		
		if(!(obj instanceof CursoAlumno)) {
			return false;
		}

		CursoAlumno a = (CursoAlumno) obj;
		
		return this.alumnoId != null && this.alumnoId.equals(a.getAlumnoId());
	}
	
	
}
