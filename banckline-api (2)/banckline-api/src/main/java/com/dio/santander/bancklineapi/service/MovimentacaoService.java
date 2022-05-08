package com.dio.santander.bancklineapi.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.santander.bancklineapi.dto.NovaMovimentacao;
import com.dio.santander.bancklineapi.model.Correntista;
import com.dio.santander.bancklineapi.model.Movimentacao;
import com.dio.santander.bancklineapi.model.MovimentacaoTipo;
import com.dio.santander.bancklineapi.repository.CorrentistaRepository;
import com.dio.santander.bancklineapi.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {
	
	@Autowired MovimentacaoRepository repository;
	
	@Autowired
	private CorrentistaRepository correntistaRepository;
	
	public void save(NovaMovimentacao novaMovimentacao) {
		Movimentacao movimentacao = new Movimentacao();
		
		
		Double valor = novaMovimentacao.getTipo()== MovimentacaoTipo.RECEITA ? novaMovimentacao.getValor() : novaMovimentacao.getValor() * -1;
		
		
		movimentacao.setDataHora(LocalDateTime.now());
		movimentacao.setDescrição(novaMovimentacao.getDescrição());
		movimentacao.setIdConta(novaMovimentacao.getIdConta());
		movimentacao.setTipo(novaMovimentacao.getTipo());
		movimentacao.setValor(valor);
		
		
		Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElseThrow(null);
		if(correntista != null) {
			correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor );
			correntistaRepository.save(correntista);
		}
		repository.save(movimentacao);
		
	}

}
