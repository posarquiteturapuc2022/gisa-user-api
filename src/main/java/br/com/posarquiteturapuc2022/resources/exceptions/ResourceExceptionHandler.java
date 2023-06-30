package br.com.posarquiteturapuc2022.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.posarquiteturapuc2022.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
//	@ExceptionHandler(ObjectNotFoundException.class)
//	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException ex, HttpServletRequest request) {
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
//				new StandardError(
//						LocalDateTime.now(), 
//						ex.getMessage(), 
//						HttpStatus.NOT_FOUND.value(), 
//						request.getRequestURI()
//						)
//				);
//	}
//
//	@ExceptionHandler(UsuarioCadastradoException.class)
//	public ResponseEntity<StandardError> userWriting(UsuarioCadastradoException ex, HttpServletRequest request) {
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
//				new StandardError(
//						LocalDateTime.now(), 
//						ex.getMessage(), 
//						HttpStatus.BAD_REQUEST.value(), 
//						request.getRequestURI()
//						)
//				);
//	}
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException ex,
			HttpServletRequest request) {

		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				ex.getMessage(), ex.getMessage(), request.getRequestURI());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(UsuarioCadastradoException.class)
	public ResponseEntity<StandardError> usuarioCadastradoException(UsuarioCadastradoException ex,
			HttpServletRequest request) {
		
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				ex.getMessage(), ex.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(TipoUsuarioException.class)
	public ResponseEntity<StandardError> usuarioCadastradoException(TipoUsuarioException ex,
			HttpServletRequest request) {
		
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				ex.getMessage(), ex.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

}
