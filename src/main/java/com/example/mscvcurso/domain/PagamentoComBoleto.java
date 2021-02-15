package com.example.mscvcurso.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import com.example.mscvcurso.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date dataVecimento;
	private Date dataPagamento;
	public PagamentoComBoleto() {
		// TODO Auto-generated constructor stub
	}

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVecimento,
			Date dataPagamento) {
		super(id, estado, pedido);
		this.dataVecimento = dataVecimento;
		this.dataPagamento = dataPagamento;
	}

	public Date getDataVecimento() {
		return dataVecimento;
	}
	public void setDataVecimento(Date dataVecimento) {
		this.dataVecimento = dataVecimento;
	}
	public Date getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	
	
	
	

}
