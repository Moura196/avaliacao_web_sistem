package com.api.avaliacao.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.avaliacao.entity.Treino;
import com.api.avaliacao.entity.dto.AtualizarStatusDTO;
import com.api.avaliacao.entity.dto.AtualizarTreinoDTO;
import com.api.avaliacao.service.TreinoService;

@RestController
@RequestMapping("/treino")
public class TreinoController {
	
	private TreinoService treinoService;

	public TreinoController(TreinoService treinoService) {
		super();
		this.treinoService = treinoService;
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<?> listartreinos() {
		try {
			List<Treino> treinos = treinoService.listarTreinos();
			return ResponseEntity.ok(treinos);
		} catch (Exception e) {
			return new ResponseEntity("Erro de consulta", HttpStatusCode.valueOf(504));
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> criarTreino(@RequestBody Treino treino) {
		try {
			Treino treinoCriado = treinoService.criarTreino(treino);
			return ResponseEntity.ok(treinoCriado);
		} catch (Exception e) {
			return new ResponseEntity("Erro de consulta", HttpStatusCode.valueOf(504));
		}
	}
	
	@DeleteMapping("/excluir/{codigo}")
	public ResponseEntity<?> excluirTreino(@PathVariable Long codigo) {
		try {
			treinoService.excluirTreino(codigo);
			return ResponseEntity.ok("Ecluído com sucesso");
		} catch (Exception e) {
			return new ResponseEntity("Erro de consulta", HttpStatusCode.valueOf(504));
		}
	}
	
	@GetMapping("/buscar/{status}")
	public ResponseEntity<?> listarTreinoPorStatus(@RequestBody String status) {
		try {
			treinoService.listarTreinoPorStatus(status);
			return ResponseEntity.ok("Ecluído com sucesso");
		} catch (Exception e) {
			return new ResponseEntity("Erro de consulta", HttpStatusCode.valueOf(504));
		}
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<?> atualizarTreino(@RequestBody AtualizarTreinoDTO treinoDTO) {
		try {
			AtualizarTreinoDTO treino = treinoService.atualizarTreino(treinoDTO);
			return ResponseEntity.ok("Ecluído com sucesso");
		} catch (Exception e) {
			return new ResponseEntity("Erro de consulta", HttpStatusCode.valueOf(504));
		}
	}
	
	@PatchMapping("/atualizar/status")
	public ResponseEntity<?> atualizarStatus(@RequestBody AtualizarStatusDTO statusDTO) {
		try {
			Treino treino = treinoService.atualizarStatus(statusDTO);
			return ResponseEntity.ok("Ecluído com sucesso");
		} catch (Exception e) {
			return new ResponseEntity("Erro de consulta", HttpStatusCode.valueOf(504));
		}
	}
	
	@GetMapping("/buscar/{codigo}")
	public ResponseEntity<?> listarTreinoPorCodigo(@RequestBody Long codigo) {
		try {
			Optional<Treino> treino = treinoService.listarTreinoPorCodigo(codigo);
			
			if (Optional.ofNullable(treino).isPresent())
				return ResponseEntity.ok(treino.get());
			else
				return ResponseEntity.notFound().build();
			
		} catch (Exception e) {
			
			return new ResponseEntity("Erro de consulta", HttpStatusCode.valueOf(504));
		
		}
	}
	
	
	
	
	
	
	
	
	
	

}
