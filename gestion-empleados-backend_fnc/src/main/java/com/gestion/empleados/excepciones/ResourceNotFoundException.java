package com.gestion.empleados.excepciones;//Excepcion personalizada

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)//No se encuentra
public class ResourceNotFoundException extends RuntimeException {

	//Es como si fuera un ID
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String mensaje) {
		super(mensaje);
	}

}
