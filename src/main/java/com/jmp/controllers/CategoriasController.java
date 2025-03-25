package com.jmp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmp.dtos.CategoriaDto;
import com.jmp.entities.Categoria;
import com.jmp.repositories.CategoriaRepository;

@RestController
@RequestMapping("/api/categorias")
public class CategoriasController {

	@Autowired
	CategoriaRepository categoriaRepository;

	@GetMapping
	public List<CategoriaDto> get() {
		List<Categoria> categorias = categoriaRepository.findAll();
		List<CategoriaDto> result = new ArrayList<>();
		for (Categoria categ : categorias) {
			CategoriaDto dto = new CategoriaDto();
			dto.setIdCategoria(categ.getIdCategoria());
			dto.setNome(categ.getNome());

			result.add(dto);
		}
		return result;
	}

}
