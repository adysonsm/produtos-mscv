package com.example.mscvcurso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mscvcurso.domain.Cidade;
import com.example.mscvcurso.domain.Cliente;
import com.example.mscvcurso.domain.Endereco;
import com.example.mscvcurso.domain.enums.TipoCliente;
import com.example.mscvcurso.dto.ClienteDTO;
import com.example.mscvcurso.dto.ClienteNewDTO;
import com.example.mscvcurso.repositories.ClienteRepository;
import com.example.mscvcurso.repositories.EnderecoRepository;
import com.example.mscvcurso.services.exceptions.DateIntegrityException;
import com.example.mscvcurso.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo;
	
	@Autowired
	private EnderecoRepository endeRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public Cliente find(Integer id) {
		
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName())); 
	}
	
	@Transactional
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		obj = repo.save(obj);
		endeRepository.saveAll(obj.getEnderecos());
		return obj;
	}


	public Cliente update(Cliente obj) {
	Cliente newObj = find(obj.getId());
	updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DateIntegrityException("Não é possivel excluir porque há entidades relacionadas");
		}
	}
	public List<Cliente> findAll() {
		return repo.findAll();
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String ordeBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page,linesPerPage,  org.springframework.data.domain.Sort.Direction.valueOf(direction),ordeBy);
		return repo.findAll(pageRequest);
	}
	
	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(),objDto.getNome(), objDto.getEmail(), null, null, null);
	}
	public Cliente fromDTO(ClienteNewDTO objDto) {
		Cliente cli = new Cliente(null,objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(), TipoCliente.toEnum(objDto.getTipo()), pe.encode(objDto.getSenha()));
		Cidade cid = new Cidade(objDto.getCiddadeId(), null, null);
		Endereco end = new Endereco(null, objDto.getLogadouro(), objDto.getNumero(), objDto.getComplemento(),objDto.getBairro(), objDto.getCep(), cli, cid);
		cli.getEnderecos().add(end);
		cli.getTelefones().add(objDto.getTelefone1());
		if(objDto.getTelefone2()!=null) {
			cli.getTelefones().add(objDto.getTelefone2());
		}
		if(objDto.getTelefone3()!=null) {
			cli.getTelefones().add(objDto.getTelefone3());
		}
		return cli;
	}
	
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
	
	
}
