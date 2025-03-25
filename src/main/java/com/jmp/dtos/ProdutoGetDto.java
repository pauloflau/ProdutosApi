package com.jmp.dtos;

import java.math.BigDecimal;

public class ProdutoGetDto {
	private Integer idProduto;
	private String nome;
	private BigDecimal preco;
	private Integer quantidade;
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
	@Override
	public String toString() {
		return "ProdutoGetDto [idProduto=" + idProduto + ", nome=" + nome + ", preco=" + preco + ", quantidade="
				+ quantidade + "]";
	}
	
	
}
