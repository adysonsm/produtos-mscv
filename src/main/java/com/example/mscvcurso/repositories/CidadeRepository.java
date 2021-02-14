package com.example.mscvcurso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mscvcurso.domain.Categoria;
import com.example.mscvcurso.domain.Cidade;
import com.example.mscvcurso.domain.Estado;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
