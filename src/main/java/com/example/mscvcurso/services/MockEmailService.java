package com.example.mscvcurso.services;

import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

import ch.qos.logback.classic.Logger;

public class MockEmailService extends AbstractEmailService {
	
	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(MockEmailService.class);
	
	@Override
	public void sendEMail(SimpleMailMessage sm) {
		LOG.info("Simulando o envio de email ...");
		LOG.info(sm.toString());
		LOG.info("Email enviado");
		
	}

}
