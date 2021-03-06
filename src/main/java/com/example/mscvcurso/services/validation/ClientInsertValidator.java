package com.example.mscvcurso.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.mscvcurso.domain.Cliente;
import com.example.mscvcurso.domain.enums.TipoCliente;
import com.example.mscvcurso.dto.ClienteNewDTO;
import com.example.mscvcurso.repositories.ClienteRepository;
import com.example.mscvcurso.resources.exception.FieldMessage;
import com.example.mscvcurso.services.validation.utils.BR;


public class ClientInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	@Autowired
	private ClienteRepository repo;
	
	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		if(objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("Cpf ou cnpj ", "CPF INVÁLIDO"));
		}
		if(objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("Cpf ou cnpj ", "cnpj INVÁLIDO"));
		}
		
		Cliente aux = repo.findByEmail(objDto.getEmail());
		if(aux!= null) {
			list.add(new FieldMessage("email", "email já existe"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
