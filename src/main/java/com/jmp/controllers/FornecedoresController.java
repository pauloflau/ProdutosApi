package com.jmp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmp.entities.Fornecedor;
import com.jmp.repositories.FornecedorRepository;

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedoresController {
	
	@Autowired
	FornecedorRepository fornecedorRepository;
	
	@GetMapping
	public List<Fornecedor> get() {
		return fornecedorRepository.findAll();
	}
}
