package com.example.mscvcurso.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.mscvcurso.domain.Categoria;
import com.example.mscvcurso.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

//	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.name LIKE %:name% AND cat in :categorias")
//	Page<Produto> search(@Param("name") String nome, @Param("categorias") List<Categoria> categorias, org.springframework.data.domain.Pageable pageRequest);
	@Transactional(readOnly = true)
	Page<Produto> findDistinctByNameContainingAndCategoriasIn(@Param("name") String nome, @Param("categorias") List<Categoria> categorias, org.springframework.data.domain.Pageable pageRequest);

}
