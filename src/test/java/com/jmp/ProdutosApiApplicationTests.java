package com.jmp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.jmp.dtos.CategoriaDto;
import com.jmp.dtos.FornecedorDto;
import com.jmp.dtos.ProdutoGetDto;
import com.jmp.dtos.ProdutoPostDto;
import com.jmp.dtos.ProdutoPutDto;
import com.jmp.repositories.CategoriaRepository;
import com.jmp.repositories.FornecedorRepository;

@SpringBootTest
@AutoConfigureMockMvc // executar os testes na API
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // ordem dos testes
class ProdutosApiApplicationTests {

	@Autowired
	FornecedorRepository fornecedorRepository;

	@Autowired
	CategoriaRepository categoriaRepository;

	@Autowired
	MockMvc mockMvc; // realizar as chamadas para a API
	@Autowired
	ObjectMapper objectMapper; // envio dos dados para a API
	// objeto para armazenar os dados do produto cadastrado
	private static ProdutoGetDto produto;

	@Test
	@Order(1)
	public void cadastrarProdutoTest() throws Exception {
		// consultar as categorias na API
		MvcResult resultCategorias = mockMvc.perform(get("/api/categorias")).andReturn();
		String contentCategorias = resultCategorias.getResponse().getContentAsString();
		List<CategoriaDto> categorias = objectMapper.readValue(contentCategorias,
				new TypeReference<List<CategoriaDto>>() {
				});
		// consultar os fornecedores na API
		MvcResult resultFornecedores = mockMvc.perform(get("/api/fornecedores")).andReturn();
		String contentFornecedores = resultFornecedores.getResponse().getContentAsString();
		List<FornecedorDto> fornecedores = objectMapper.readValue(contentFornecedores,
				new TypeReference<List<FornecedorDto>>() {
				});
		// criando os dados do produto
		ProdutoPostDto dto = new ProdutoPostDto();
		Faker faker = new Faker();
		dto.setNome(faker.commerce().productName());
		dto.setPreco(BigDecimal.valueOf(faker.number().randomDigit()));
		dto.setQuantidade(faker.number().randomDigit());
		dto.setIdCategoria(categorias.get(0).getIdCategoria());
		dto.setIdFornecedor(fornecedores.get(0).getIdFornecedor());
		// cadastrar o produto
		MvcResult resultProduto = mockMvc.perform(
				post("/api/produtos").contentType("application/json").content(objectMapper.writeValueAsString(dto)))
				.andExpect(status().isOk()).andReturn();
		// lendo os dados obtidos da API referente
		// ao produto que foi cadastrado
		String contentProduto = resultProduto.getResponse().getContentAsString();
		produto = objectMapper.readValue(contentProduto, ProdutoGetDto.class);
	}

	@Test
	@Order(2)
	public void atualizarProdutoTest() throws Exception {
		ProdutoPutDto dto = new ProdutoPutDto();
		Faker faker = new Faker();
		dto.setIdProduto(1);
		dto.setNome(faker.commerce().productName());
		dto.setPreco(BigDecimal.valueOf(faker.number().randomDigit()));
		dto.setQuantidade(faker.number().randomDigit());

		dto.setIdCategoria(1);
		dto.setIdFornecedor(1);

		mockMvc.perform(
				put("/api/produtos").contentType("application/json").content(objectMapper.writeValueAsString(dto)))
				.andExpect(status().isOk());
	}

	@Test
	@Order(3)
	public void consultarProdutoTest() throws Exception {
		mockMvc.perform(get("/api/produtos/" + produto.getIdProduto())).andExpect(status().isOk());
	}

	@Test
	@Order(4)
	public void excluirProdutoTest() throws Exception {
		mockMvc.perform(delete("/api/produtos/" + produto.getIdProduto())).andExpect(status().isOk());
	}
}
