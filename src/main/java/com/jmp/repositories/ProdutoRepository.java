package com.jmp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jmp.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
	
	@Query("select p from Produto p " +
	           "join fetch p.categoria c " +
	           "join fetch p.fornecedor f " +
	           "order by p.idProduto")
	List<Produto> findAll();
	
	@Query("select p from Produto p " +
	           "join fetch p.categoria c " +
	           "join fetch p.fornecedor f " +
	           "where idProduto =:param")
	Produto find(@Param("param")Integer idProduto);
}
