package com.example.mscvcurso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.mscvcurso.domain.Categoria;
import com.example.mscvcurso.domain.Cidade;
import com.example.mscvcurso.domain.Cliente;
import com.example.mscvcurso.domain.Endereco;
import com.example.mscvcurso.domain.Estado;
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
import com.example.mscvcurso.repositories.PagamentoRepository;
import com.example.mscvcurso.repositories.PedidoRepository;
import com.example.mscvcurso.repositories.ProdutoRepository;

@SpringBootApplication
public class MsvcursoApplication implements CommandLineRunner {

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

	public static void main(String[] args) {
		SpringApplication.run(MsvcursoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "impressora", 800.00);
		Produto p3 = new Produto(null, "mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "são Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cl1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "96549493182712", TipoCliente.PESSOAFISICA);
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
		
		pedidoRepository.saveAll(Arrays.asList(pe1,pe2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		

		

		
	

	}

}
