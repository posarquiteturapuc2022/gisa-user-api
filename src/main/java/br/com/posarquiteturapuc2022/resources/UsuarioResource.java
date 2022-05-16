package br.com.posarquiteturapuc2022.resources;

import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.posarquiteturapuc2022.domain.Usuario;


public interface UsuarioResource {

	@GetMapping(value = "/{id}")
	ResponseEntity<Usuario> findById(@PathVariable Long id);

	@GetMapping
	ResponseEntity<List<Usuario>> findAll();
	
}
