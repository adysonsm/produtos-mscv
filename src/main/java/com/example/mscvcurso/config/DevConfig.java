package com.example.mscvcurso.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.mscvcurso.services.DBServices;
import com.example.mscvcurso.services.EmailService;
import com.example.mscvcurso.services.SmtpEmailService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBServices dbServices;
	private String stragy;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	@Bean
	public boolean instantiateDataBase() throws ParseException {
		if (!"create".equals(stragy)) {
			return false;
		}
		dbServices.instatiateTestDateBase();
		return true;
	}

	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
}
