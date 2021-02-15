package com.example.mscvcurso.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.example.mscvcurso.domain.Categoria;

public class CategoriaDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	@NotEmpty(message = "Preenchimento obirgatório")
	@Length(min = 5, max = 80, message = "o tamanho deve ser entre 5 e 80 caracteries")
	private String nome;
	
	public CategoriaDTO() {
		// TODO Auto-generated constructor stub
	}
	public CategoriaDTO(Categoria obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
	}

	public CategoriaDTO(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	

}
