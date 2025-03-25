package com.jmp.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmp.dtos.FornecedorDto;
import com.jmp.entities.Fornecedor;
import com.jmp.repositories.FornecedorRepository;

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedoresController {
	
	@Autowired
	FornecedorRepository fornecedorRepository;
	
	@GetMapping
	public List<FornecedorDto> get() {
		ModelMapper modelMapper = new ModelMapper();
		
		List<Fornecedor> fornecedores = fornecedorRepository.findAll();
		List<FornecedorDto> result = modelMapper.map(fornecedores, new TypeToken<List<FornecedorDto>>() {}.getType()); 
		
		return result;
	}
}
