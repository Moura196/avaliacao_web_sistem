package com.api.avaliacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.avaliacao.entity.Exercicio;
import com.api.avaliacao.entity.Treino;
import com.api.avaliacao.entity.dto.CriarExercicioDTO;
import com.api.avaliacao.repository.ExercicioRepository;

@Service
public class ExercicioService {
	
	private ExercicioRepository exercicioRepository;
	private TreinoService treinoService;
	
	public ExercicioService(ExercicioRepository exercicioRepository, TreinoService treinoService) {
		this.exercicioRepository = exercicioRepository;
		this.treinoService = treinoService;
	}
	
	public Exercicio criarExercicio(CriarExercicioDTO exercicioDTO) throws Exception {
		
		Exercicio novoExercicio = new Exercicio();
		novoExercicio.setNumSeries(exercicioDTO.getNumSeries());
		novoExercicio.setRepeticoes(exercicioDTO.getRepeticoes());
		novoExercicio.setTempDescanso(exercicioDTO.getTempDescanso());
		
		Optional<Treino> treino = treinoService.listarTreinoPorCodigo(exercicioDTO.getCodigo());
		if (Optional.ofNullable(treino).isPresent()) {
			novoExercicio.setTreino(treino.get());
			exercicioRepository.save(novoExercicio);
		} else {
			throw new Exception("Treino não encontrado");
		}
		return novoExercicio;
	}
	
	public List<Exercicio> listarExercicios() {
		return exercicioRepository.findAll();
	}
	
}


















