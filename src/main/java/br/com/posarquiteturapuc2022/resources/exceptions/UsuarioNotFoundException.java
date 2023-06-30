package br.com.posarquiteturapuc2022.resources.exceptions;

public class UsuarioNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 3230839809815501948L;

	public UsuarioNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsuarioNotFoundException(String message) {
		super(message);
	}

}
