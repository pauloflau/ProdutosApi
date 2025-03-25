package com.jmp.dtos;

import java.math.BigDecimal;

public class ProdutoPutDto {
	private Integer idProduto;
	private String nome;
	private BigDecimal preco;
	private Integer quantidade;
	private Integer idFornecedor;
	private Integer idCategoria;
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
	public Integer getIdFornecedor() {
		return idFornecedor;
	}
	public void setIdFornecedor(Integer idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	@Override
	public String toString() {
		return "ProdutoPutDto [idProduto=" + idProduto + ", nome=" + nome + ", preco=" + preco + ", quantidade="
				+ quantidade + ", idFornecedor=" + idFornecedor + ", idCategoria=" + idCategoria + "]";
	}
	
	

}
