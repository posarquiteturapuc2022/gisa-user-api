package br.com.posarquiteturapuc2022.resources.exceptions;

public class UsuarioCadastradoException extends RuntimeException {
	
	private static final long serialVersionUID = 3230839809815501948L;

	public UsuarioCadastradoException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsuarioCadastradoException(String message) {
		super(message);
	}

}
