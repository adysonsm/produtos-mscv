package com.example.mscvcurso.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemPedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private ItemPedidoPk id = new ItemPedidoPk();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	private Double desconto;
	private Integer quantidade;
	private Double preco;

	public ItemPedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
		super();
		id.setProduto(produto);
		id.setPedido(pedido);
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public double getSubtotal() {
		return (preco - desconto) * quantidade;
	}

	@JsonIgnore
	public Pedido gePedido() {
		return id.getPedido();
	}

	@JsonIgnore
	public Produto geProduto() {
		return id.getProduto();
	}

	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}

	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}

	public ItemPedidoPk getId() {
		return id;
	}

	public void setId(ItemPedidoPk id) {
		this.id = id;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

}
