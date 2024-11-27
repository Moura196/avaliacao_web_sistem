package com.api.avaliacao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.avaliacao.entity.Treino;

public interface TreinoRepository extends JpaRepository<Treino, Long> {

	Optional<Treino> findByIdOuStatus(Long codigo, String status);

}
