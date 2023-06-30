package br.com.posarquiteturapuc2022.resources.exceptions;

public class CpfCnpjUsuarioException extends RuntimeException {
	
	private static final long serialVersionUID = -874654733680601398L;

	public CpfCnpjUsuarioException(String message, Throwable cause) {
		super(message, cause);
	}

	public CpfCnpjUsuarioException(String message) {
		super(message);
	}

}
