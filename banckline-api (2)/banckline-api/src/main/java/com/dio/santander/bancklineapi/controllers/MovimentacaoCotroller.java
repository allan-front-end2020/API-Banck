package com.dio.santander.bancklineapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.santander.bancklineapi.dto.NovaMovimentacao;
import com.dio.santander.bancklineapi.dto.NovoCorrentista;
import com.dio.santander.bancklineapi.model.Correntista;
import com.dio.santander.bancklineapi.model.Movimentacao;
import com.dio.santander.bancklineapi.repository.CorrentistaRepository;
import com.dio.santander.bancklineapi.repository.MovimentacaoRepository;
import com.dio.santander.bancklineapi.service.CorrentistaService;
import com.dio.santander.bancklineapi.service.MovimentacaoService;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoCotroller {
	
	@Autowired
    private MovimentacaoRepository repository;
	
	@Autowired
	private MovimentacaoService service;
	
	
	
	@GetMapping
	public List<Movimentacao>findAll(){
		return repository.findAll();
	}
	
	@PostMapping
	public void  save ( @RequestBody NovaMovimentacao correntista) {
		service.save(correntista);
		
	}

}
