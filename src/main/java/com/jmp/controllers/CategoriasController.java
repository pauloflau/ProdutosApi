package com.jmp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmp.entities.Categoria;
import com.jmp.repositories.CategoriaRepository;

@RestController
@RequestMapping("/api/categorias")
public class CategoriasController {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@GetMapping
	public List<Categoria> get() {
		return categoriaRepository.findAll();
	}
}
