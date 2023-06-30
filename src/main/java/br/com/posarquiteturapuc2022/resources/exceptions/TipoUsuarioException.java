package br.com.posarquiteturapuc2022.resources.exceptions;

public class TipoUsuarioException extends RuntimeException {
	
	private static final long serialVersionUID = -874654733680601398L;

	public TipoUsuarioException(String message, Throwable cause) {
		super(message, cause);
	}

	public TipoUsuarioException(String message) {
		super(message);
	}

}
