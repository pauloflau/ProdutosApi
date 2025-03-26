package com.jmp.dtos;

import java.math.BigDecimal;

public class ProdutoGetDto {
	private Integer idProduto;
	private String nome;
	private BigDecimal preco;
	private Integer quantidade;
	private String fornecedor;
	private String categoria;
	
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

	
	
	
	public String getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	@Override
	public String toString() {
		return "ProdutoGetDto [idProduto=" + idProduto + ", nome=" + nome + ", preco=" + preco + ", quantidade="
				+ quantidade + ", fornecedor=" + fornecedor + ", categoria=" + categoria + "]";
	}
}
