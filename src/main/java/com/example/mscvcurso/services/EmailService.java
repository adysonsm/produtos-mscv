package com.example.mscvcurso.services;

import java.text.SimpleDateFormat;

import org.springframework.mail.SimpleMailMessage;

import com.example.mscvcurso.domain.Pedido;

public interface EmailService {
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEMail(SimpleMailMessage sm);

}
