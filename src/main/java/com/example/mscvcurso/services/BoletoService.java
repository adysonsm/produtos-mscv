package com.example.mscvcurso.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.mscvcurso.domain.PagamentoComBoleto;

@Service
public class BoletoService {
	
	public void precimentoComBoleto(PagamentoComBoleto pagto, Date instancePedido) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instancePedido);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pagto.setDataPagamento(cal.getTime());
	}

}
