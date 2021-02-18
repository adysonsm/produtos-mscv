package com.example.mscvcurso.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.mscvcurso.domain.Categoria;
import com.example.mscvcurso.domain.Cidade;
import com.example.mscvcurso.domain.Cliente;
import com.example.mscvcurso.domain.Endereco;
import com.example.mscvcurso.domain.Estado;
import com.example.mscvcurso.domain.ItemPedido;
import com.example.mscvcurso.domain.Pagamento;
import com.example.mscvcurso.domain.PagamentoComBoleto;
import com.example.mscvcurso.domain.PagamentoComCartao;
import com.example.mscvcurso.domain.Pedido;
import com.example.mscvcurso.domain.Produto;
import com.example.mscvcurso.domain.enums.EstadoPagamento;
import com.example.mscvcurso.domain.enums.TipoCliente;
import com.example.mscvcurso.repositories.CategoriaRepository;
import com.example.mscvcurso.repositories.CidadeRepository;
import com.example.mscvcurso.repositories.ClienteRepository;
import com.example.mscvcurso.repositories.EnderecoRepository;
import com.example.mscvcurso.repositories.EstadoRepository;
import com.example.mscvcurso.repositories.ItemPedidoRepository;
import com.example.mscvcurso.repositories.PagamentoRepository;
import com.example.mscvcurso.repositories.PedidoRepository;
import com.example.mscvcurso.repositories.ProdutoRepository;

@Service
public class DBServices {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;

	public void instatiateTestDateBase() throws ParseException {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Cama mesa e banho");
		Categoria cat4 = new Categoria(null, "Eletrônicos");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");
		Categoria cat8 = new Categoria(null, "Alimentação");
		Categoria cat9 = new Categoria(null, "Esporte");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "impressora", 800.00);
		Produto p3 = new Produto(null, "mouse", 80.00);
		Produto p4 = new Produto(null, "mesa de escritorio", 300.00);
		Produto p5 = new Produto(null, "toalha", 50.00);
		Produto p6 = new Produto(null, "colcha", 200.00);
		Produto p7 = new Produto(null, "Rv True color", 120.00);
		Produto p8 = new Produto(null, "Roçadeira", 800.00);
		Produto p9 = new Produto(null, "abajour", 100.00);
		Produto p10 = new Produto(null, "Pendente", 180.00);
		Produto p11 = new Produto(null, "Shampoo", 90.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2, p4));
		cat3.getProdutos().addAll(Arrays.asList(p5, p6));
		cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
		cat5.getProdutos().addAll(Arrays.asList(p8));
		;
		cat6.getProdutos().addAll(Arrays.asList(p9, p10));
		cat7.getProdutos().addAll(Arrays.asList(p11));

		p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		p7.getCategorias().addAll(Arrays.asList(cat4));
		p8.getCategorias().addAll(Arrays.asList(cat5));
		p9.getCategorias().addAll(Arrays.asList(cat6));
		p10.getCategorias().addAll(Arrays.asList(cat6));
		p11.getCategorias().addAll(Arrays.asList(cat7));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "são Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cl1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "96549493182712", TipoCliente.PESSOAFISICA, pe.encode("123"));
		cl1.getTelefones().addAll(Arrays.asList("+55 11 99119-8591", "+55 11 99119-4040"));

		Endereco e1 = new Endereco(null, "Rua flores", "300", "Apto 303", "Jardim", "382220834", cl1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "382220834", cl1, c2);

		cl1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.saveAll(Arrays.asList(cl1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

		Pedido pe1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cl1, e1);
		Pedido pe2 = new Pedido(null, sdf.parse("10/10/2017 19:32"), cl1, e2);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, pe1, 6);
		pe1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, pe2, sdf.parse("20/10/2017 00:00"),
				null);
		pe2.setPagamento(pagto2);

		cl1.getPedidos().addAll(Arrays.asList(pe1, pe2));

		pedidoRepository.saveAll(Arrays.asList(pe1, pe2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

		ItemPedido ip1 = new ItemPedido(pe1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(pe1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(pe2, p2, 100.00, 1, 800.00);

		pe1.getItens().addAll(Arrays.asList(ip1, ip2));
		pe2.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
	}
}
