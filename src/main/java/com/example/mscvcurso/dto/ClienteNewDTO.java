package com.example.mscvcurso.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.example.mscvcurso.services.validation.ClienteInsert;

@ClienteInsert
public class ClienteNewDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@NotEmpty(message = "prechimento obrigatorio")
	@Length(min = 0, max = 120)
	private String nome;
	
	@NotEmpty(message = "prechimento obrigatorio")
	@Email(message = "email inválido")
	private String email;
	
	@NotEmpty(message = "prechimento obrigatorio")
	private String cpfOuCnpj;
	
	private Integer tipo; 
	@NotEmpty(message = "prechimento obrigatorio")
	private String logadouro;
	
	@NotEmpty(message = "prechimento obrigatorio")
	private String numero;
	
	private String complemento;
	private String bairro;
	
	@NotEmpty(message = "prechimento obrigatorio")
	private String cep;
	
	@NotEmpty(message = "prechimento obrigatorio")
	private String telefone1;
	private String telefone2;
	private String telefone3;
	
	private Integer ciddadeId;

	public ClienteNewDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the cpfOuCnpj
	 */
	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	/**
	 * @param cpfOuCnpj the cpfOuCnpj to set
	 */
	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	/**
	 * @return the tipo
	 */
	public Integer getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the logadouro
	 */
	public String getLogadouro() {
		return logadouro;
	}

	/**
	 * @param logadouro the logadouro to set
	 */
	public void setLogadouro(String logadouro) {
		this.logadouro = logadouro;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the complemento
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * @param complemento the complemento to set
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * @param cep the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * @return the telefone1
	 */
	public String getTelefone1() {
		return telefone1;
	}

	/**
	 * @param telefone1 the telefone1 to set
	 */
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	/**
	 * @return the telefone2
	 */
	public String getTelefone2() {
		return telefone2;
	}

	/**
	 * @param telefone2 the telefone2 to set
	 */
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	/**
	 * @return the telefone3
	 */
	public String getTelefone3() {
		return telefone3;
	}

	/**
	 * @param telefone3 the telefone3 to set
	 */
	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}

	/**
	 * @return the ciddadeId
	 */
	public Integer getCiddadeId() {
		return ciddadeId;
	}

	/**
	 * @param ciddadeId the ciddadeId to set
	 */
	public void setCiddadeId(Integer ciddadeId) {
		this.ciddadeId = ciddadeId;
	}
	
	
	
	
	

}
