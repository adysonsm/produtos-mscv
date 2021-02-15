package com.example.mscvcurso.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	/**
	 * @return the list
	 */
	public List<FieldMessage> getErrors() {
		return errors;
	}

	/**
	 * @param list the list to set
	 */
	public void addError(String fildName, String messagem) {
		this.errors.add(new FieldMessage(fildName, messagem));
	}

	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
