package com.example.mscvcurso.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.mscvcurso.services.DBServices;
import com.example.mscvcurso.services.EmailService;
import com.example.mscvcurso.services.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBServices dbServices;

		@Bean
		public boolean instantiateDataBase() throws ParseException {
			dbServices.instatiateTestDateBase();
			return true;
		}
		
		@Bean
		public EmailService emailService() {
			return new MockEmailService();
		}
}
