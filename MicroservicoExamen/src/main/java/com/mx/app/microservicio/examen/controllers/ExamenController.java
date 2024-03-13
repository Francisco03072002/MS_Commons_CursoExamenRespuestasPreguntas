package com.mx.app.microservicio.examen.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mx.app.microservicio.examen.services.ExamenService;
import com.mx.microservicios.commons.controllers.CommonController;
import com.mx.microservicios.commons.examenes.models.entity.Examen;

import jakarta.validation.Valid;

@RestController
public class ExamenController extends CommonController<Examen, ExamenService>{

	@GetMapping("/respondidos-por-preguntas")
	public ResponseEntity<?> obtenerExamenesIdsPorPreguntasIdRespondidas(@RequestParam List<Long> preguntaIds){
		return ResponseEntity.ok().body(service.findExamenesIdsConRespuestasByPreguntaIds(preguntaIds));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Examen examen, BindingResult result, @PathVariable Long id){
		
		if(result.hasErrors()) {
			return this.validar(result);
		}
		
		Optional<Examen> o = service.findById(id);
		
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Examen examenDb = o.get();
		examenDb.setNombre(examen.getNombre());
		
		examenDb.getPreguntas()
		.stream()
		.filter(pdb -> !examen.getPreguntas().contains(pdb))
		.forEach(examenDb::removePregunta);
		
		examenDb.setPreguntas(examen.getPreguntas());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(examenDb));
	}
	
	@GetMapping("/filtrar/{term}")
	public ResponseEntity<?> filtrar(@PathVariable String term){
		return ResponseEntity.ok(service.findByNombre(term));
	}
	
	@GetMapping("/asignaturas")
	public ResponseEntity<?> listarAsignaturas(){
		return ResponseEntity.ok(service.findAllAsignaturas());
	}
	
}
