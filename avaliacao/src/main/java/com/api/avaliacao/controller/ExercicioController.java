package com.api.avaliacao.controller;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.avaliacao.entity.Exercicio;
import com.api.avaliacao.entity.dto.CriarExercicioDTO;
import com.api.avaliacao.service.ExercicioService;

@RestController
@RequestMapping("/exercicio")
public class ExercicioController {
	
	private ExercicioService exercicioService;

	public ExercicioController(ExercicioService exercicioService) {
		this.exercicioService = exercicioService;
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<?> listarExercicios() {
		try {
			List<Exercicio> exercicios = exercicioService.listarExercicios();
			return ResponseEntity.ok(exercicios);
		} catch (Exception e) {
			return new ResponseEntity("Erro de consulta", HttpStatusCode.valueOf(504));
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> criarExercicio(@RequestBody CriarExercicioDTO exercicioDTO) {
		try {
			Exercicio exercicioCriado = exercicioService.criarExercicio(exercicioDTO);
			return ResponseEntity.ok(exercicioCriado);
		} catch (Exception e) {
			return new ResponseEntity("Erro de consulta", HttpStatusCode.valueOf(504));
		}
	}

}
