package com.dio.santander.bancklineapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.santander.bancklineapi.dto.NovoCorrentista;
import com.dio.santander.bancklineapi.model.Correntista;
import com.dio.santander.bancklineapi.repository.CorrentistaRepository;
import com.dio.santander.bancklineapi.service.CorrentistaService;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaCotroller {
	
	@Autowired
	private CorrentistaRepository repository;
	
	@Autowired
	private CorrentistaService service;
	
	
	
	@GetMapping
	public List<Correntista> findAll(){
		return repository.findAll();
	}
	
	@PostMapping
	public void  save ( @RequestBody NovoCorrentista correntista) {
		service.save(correntista);
		
	}

}
