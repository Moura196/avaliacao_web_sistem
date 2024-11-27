package com.api.avaliacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.avaliacao.entity.Treino;
import com.api.avaliacao.entity.dto.AtualizarStatusDTO;
import com.api.avaliacao.entity.dto.AtualizarTreinoDTO;
import com.api.avaliacao.repository.TreinoRepository;

@Service
public class TreinoService {
	
	private TreinoRepository treinoRepository;

	public TreinoService(TreinoRepository treinoRepository) {
		this.treinoRepository = treinoRepository;
	}
	
	public List<Treino> listarTreinos(){
		return treinoRepository.findAll();
	}

	public Optional<Treino> listarTreinoPorCodigo(Long codigo) {
		Optional<Treino> treino = treinoRepository.findById(codigo);
		return treino;
	}
	
	public void excluirTreino(Long codigo) {
		treinoRepository.deleteById(codigo);
	}
	
	public Treino criarTreino(Treino treino) {
		String status = treino.getStatus();
		treino.setStatus(status);
		String nome = treino.getNome();
		treino.setNome(nome);
		treinoRepository.save(treino);
		return treino;
	}
	
	public Treino atualizarStatus(AtualizarStatusDTO statusDTO) {
		Optional<Treino> treino = treinoRepository.findById(statusDTO.getCodigo());
		String status = statusDTO.getStatus();
		treino.get().setStatus(status);
		treinoRepository.save(treino.get());
		return treino.get();
	}
	
	public AtualizarTreinoDTO atualizarTreino(AtualizarTreinoDTO treinoDTO) throws Exception {
		Optional<Treino> treino = treinoRepository.findById(treinoDTO.getCodigo());
		if (Optional.ofNullable(treino).isPresent()) {
			treino.get().setNome(treinoDTO.getNome());
			treinoRepository.save(treino.get());
			
			return treinoDTO;
		}
		
		throw new Exception("Treino não existe");
	}
	
	public Optional<Treino> listarTreinoPorStatus(String status) {
		Optional<Treino> treino = treinoRepository.findByStatus(status);
		return treino;
	}

}