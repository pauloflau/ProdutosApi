package com.jmp.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmp.dtos.ProdutoGetDto;
import com.jmp.dtos.ProdutoPostDto;
import com.jmp.entities.Categoria;
import com.jmp.entities.Fornecedor;
import com.jmp.entities.Produto;
import com.jmp.repositories.CategoriaRepository;
import com.jmp.repositories.FornecedorRepository;
import com.jmp.repositories.ProdutoRepository;


@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	FornecedorRepository fornecedorRepository;
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@PostMapping
	public String post(@RequestBody ProdutoPostDto dto) {

		Produto produto = new Produto();
		produto.setNome(dto.getNome());
		produto.setPreco(dto.getPreco());
		produto.setQuantidade(dto.getQuantidade());
		
		Fornecedor fornecedor = fornecedorRepository.findById(dto.getIdFornecedor()).get();
		produto.setFornecedor(fornecedor); 
		
		Categoria categoria = categoriaRepository.findById(dto.getIdCategoria()).get();		
		produto.setCategoria(categoria);			

		//salvar o produto no banco de dados*/
		produtoRepository.save(produto);
		
		return "Produto cadastrado com sucesso.";
		
	}
	
	@PutMapping
	public void put() {
		
	}
	
	@DeleteMapping
	public void delete() {
		
	}
	
	@GetMapping
	public List<ProdutoGetDto> get() {
		List<Produto> produtos = produtoRepository.findAll();
		List<ProdutoGetDto> result = new ArrayList<ProdutoGetDto>();
		
		for(Produto prod : produtos) {
			ProdutoGetDto dto = new ProdutoGetDto();
			dto.setIdProduto(prod.getIdProduto());
			dto.setNome(prod.getNome());
			dto.setPreco(prod.getPreco());
			dto.setQuantidade(prod.getQuantidade());
			
			result.add(dto);
			
		}
		
		return result;
		
	}

}
