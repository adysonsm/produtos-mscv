package com.example.mscvcurso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mscvcurso.domain.Cliente;
import com.example.mscvcurso.repositories.ClienteRepository;
import com.example.mscvcurso.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName())); 
	}
}