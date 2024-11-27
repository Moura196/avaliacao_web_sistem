package com.api.avaliacao.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Exercicio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name = "num_series", nullable = false)
	private String numSeries; // Número de séries
	
	@Column(name = "num_repeticoes", nullable = false)
	private String repeticoes; // Número de repetições
	
	@Column(name = "temp_descanso", nullable = false)
	private String tempDescanso; // Descanso entre séries
	
	@ManyToOne
	@JoinColumn(name = "treino", nullable = false)
	@JsonIgnoreProperties("exercicios")
	private Treino treino;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNumSeries() {
		return numSeries;
	}

	public void setNumSeries(String numSeries) {
		this.numSeries = numSeries;
	}

	public String getRepeticoes() {
		return repeticoes;
	}

	public void setRepeticoes(String repeticoes) {
		this.repeticoes = repeticoes;
	}

	public String getTempDescanso() {
		return tempDescanso;
	}

	public void setTempDescanso(String tempDescanso) {
		this.tempDescanso = tempDescanso;
	}
	
	public Treino getTreino() {
		return treino;
	}

	public void setTreino(Treino treino) {
		this.treino = treino;
	}

}
