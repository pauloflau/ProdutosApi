package com.jmp.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_categoria")
public class Categoria {
	
	@Id
	@Column(name="idcategoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer idCategoria;
	
	@Column(name = "nome")
	private String nome;
	
	//one classe que estou e many a Outra classe
	@OneToMany(mappedBy = "categoria") //coloquei o nome do atrbito que veio o muitos pra um(classe Produto)
	private List<Produto> produtos;
	
	public Categoria() {
		// TODO Auto-generated constructor stub
	}
	public Categoria(Integer idCategoria, String nome, List<Produto> produtos) {
		super();
		this.idCategoria = idCategoria;
		this.nome = nome;
		this.produtos = produtos;
	}
	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", nome=" + nome  + "]";
	}
	
}
