package com.api.avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.avaliacao.entity.Exercicio;

public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {

}
