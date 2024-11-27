package com.api.avaliacao.entity.dto;

public class CriarExercicioDTO {
	
	private String numSeries;
	private String repeticoes;
	private String tempDescanso;
	private Long codigo;
	
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

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

}
