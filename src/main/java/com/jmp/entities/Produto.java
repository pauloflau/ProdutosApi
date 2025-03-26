package com.jmp.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_produto")
public class Produto {
	
	@Id
	@Column(name="idproduto")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer idProduto;
	
	@Column(name = "nome", length = 100, nullable = false)
	private String nome;
	
	@Column(name = "preco", precision = 10, scale = 2, nullable = false)
	private BigDecimal preco;
	
	@Column(name = "quantidade")
	private Integer quantidade;
	
	@ManyToOne//many classe que estou e one a Outra classe
	@JoinColumn(name="idcategoria") //especifico um nome para chave estrangeira
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name="idfornecedor")
	private Fornecedor fornecedor;
	
	public Produto() {
		// TODO Auto-generated constructor stub
	}

	public Produto(Integer idProduto, String nome, BigDecimal preco, Integer quantidade, Categoria categoria,
			Fornecedor fornecedor) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.categoria = categoria;
		this.fornecedor = fornecedor;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", nome=" + nome + ", preco=" + preco + ", quantidade=" + quantidade
				+  "]";
	}

	
	
	
}
