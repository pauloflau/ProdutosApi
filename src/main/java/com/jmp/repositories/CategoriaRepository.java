package com.jmp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jmp.entities.Categoria;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
	
	@Query("select c from Categoria c order by c.nome")
	List<Categoria> findAll();
}
