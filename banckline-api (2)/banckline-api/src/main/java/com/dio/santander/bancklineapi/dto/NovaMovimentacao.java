package com.dio.santander.bancklineapi.dto;

import com.dio.santander.bancklineapi.model.MovimentacaoTipo;

public class NovaMovimentacao {


	private String descrição;
	private Double valor;
	
	
	private MovimentacaoTipo tipo;
	public String getDescrição() {
		return descrição;
	}
	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public MovimentacaoTipo getTipo() {
		return tipo;
	}
	public void setTipo(MovimentacaoTipo tipo) {
		this.tipo = tipo;
	}
	public Integer getIdConta() {
		return idConta;
	}
	public void setIdConta(Integer idConta) {
		this.idConta = idConta;
	}
	private Integer idConta;
}
