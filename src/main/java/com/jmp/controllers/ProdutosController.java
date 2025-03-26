package com.jmp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmp.dtos.ProdutoGetDto;
import com.jmp.dtos.ProdutoPostDto;
import com.jmp.dtos.ProdutoPutDto;
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
	public ProdutoGetDto post(@RequestBody ProdutoPostDto dto) {

		Produto produto = new Produto();
		produto.setNome(dto.getNome());
		produto.setPreco(dto.getPreco());
		produto.setQuantidade(dto.getQuantidade());

		Fornecedor fornecedor = fornecedorRepository.findById(dto.getIdFornecedor()).get();
		produto.setFornecedor(fornecedor);

		Categoria categoria = categoriaRepository.findById(dto.getIdCategoria()).get();
		produto.setCategoria(categoria);

		// salvar o produto no banco de dados*/
		produtoRepository.save(produto);

		ModelMapper modelMapper = new ModelMapper();// volto com o model mapper porem poderia fazer na mao
		Produto resultado = produtoRepository.find(produto.getIdProduto());
		return modelMapper.map(resultado, ProdutoGetDto.class);

	}

	@PutMapping
	public ProdutoPutDto put(@RequestBody ProdutoPutDto dto) throws Exception {

		// Verifica se o ID do produto está presente
		if (dto.getIdProduto() == null) {
			throw new IllegalArgumentException("ID do produto não pode ser nulo.");
		}

		// Verifica se o produto existe
		Produto produto = produtoRepository.findById(dto.getIdProduto())
				.orElseThrow(() -> new Exception("Produto com ID " + dto.getIdProduto() + " não encontrado."));

		produto = new Produto();
		produto.setIdProduto(dto.getIdProduto());
		produto.setNome(dto.getNome());
		produto.setPreco(dto.getPreco());
		produto.setQuantidade(dto.getQuantidade());

		Fornecedor fornecedor = fornecedorRepository.findById(dto.getIdFornecedor()).get();
		produto.setFornecedor(fornecedor);

		Categoria categoria = categoriaRepository.findById(dto.getIdCategoria()).get();
		produto.setCategoria(categoria);

		// salvar o produto no banco de dados*/
		produtoRepository.save(produto);

		ModelMapper modelMapper = new ModelMapper();// volto com o model mapper porem poderia fazer na mao
		Produto resultado = produtoRepository.find(produto.getIdProduto());
		return modelMapper.map(resultado, ProdutoPutDto.class);
	}

	@DeleteMapping("{idProduto}")
	public ProdutoGetDto delete(@PathVariable Integer idProduto) throws Exception {

		// Verifica se o produto existe
		Produto produto = produtoRepository.findById(idProduto)
				.orElseThrow(() -> new Exception("Produto com ID " + idProduto + " não encontrado."));
		
		produtoRepository.delete(produto);
		
		ModelMapper modelMapper = new ModelMapper();// volto com o model mapper porem poderia fazer na mao
		return modelMapper.map(produto, ProdutoGetDto.class);		 
	}

	@GetMapping
	public List<ProdutoGetDto> get() {
		List<Produto> produtos = produtoRepository.findAll();
		List<ProdutoGetDto> result = new ArrayList<ProdutoGetDto>();

		for (Produto prod : produtos) {
			ProdutoGetDto dto = new ProdutoGetDto();
			dto.setFornecedor(prod.getFornecedor().getNome());
			dto.setCategoria(prod.getCategoria().getNome());
			dto.setIdProduto(prod.getIdProduto());
			dto.setNome(prod.getNome());
			dto.setPreco(prod.getPreco());
			dto.setQuantidade(prod.getQuantidade());

			result.add(dto);

		}
		return result;
	}

	@GetMapping("{idProduto}")
	public ProdutoGetDto getById(@PathVariable Integer idProduto) {
		/* PASSANDO VIA MODEL MAPPER */
		/*****
		 * ModelMapper modelMapper = new ModelMapper();
		 * 
		 * Produto produto = produtoRepository.find(idProduto); ProdutoGetDto dto =
		 * modelMapper.map(produto, ProdutoGetDto.class);
		 ***/

		Produto produto = produtoRepository.find(idProduto);

		ProdutoGetDto dto = new ProdutoGetDto();
		dto.setFornecedor(produto.getFornecedor().getNome());
		dto.setCategoria(produto.getCategoria().getNome());
		dto.setIdProduto(produto.getIdProduto());
		dto.setNome(produto.getNome());
		dto.setPreco(produto.getPreco());
		dto.setQuantidade(produto.getQuantidade());
		return dto;
	}

}
