package com.example.mscvcurso.services;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SmtpEmailService extends AbstractEmailService {
  @Autowired
  private MailSender mailSender;
  private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);
	
	@Override
	public void sendEMail(SimpleMailMessage sm) {
		LOG.info("Simulando o envio de email ...");
		mailSender.send(sm);
		LOG.info("Email enviado");
		
	}

}
