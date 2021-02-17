package com.example.mscvcurso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.mscvcurso.domain.Categoria;
import com.example.mscvcurso.domain.Produto;
import com.example.mscvcurso.repositories.CategoriaRepository;
import com.example.mscvcurso.repositories.ProdutoRepository;
import com.example.mscvcurso.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository repo;
	@Autowired
	private CategoriaRepository categoriaRepo;
	
	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName())); 		
	}
	
	
	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String ordeBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page,linesPerPage,  org.springframework.data.domain.Sort.Direction.valueOf(direction),ordeBy);
		List<Categoria> categorias = categoriaRepo.findAllById(ids);
		return repo.findDistinctByNameContainingAndCategoriasIn(nome, categorias, pageRequest);
	}
}
