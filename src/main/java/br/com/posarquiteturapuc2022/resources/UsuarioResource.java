package br.com.posarquiteturapuc2022.resources;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.posarquiteturapuc2022.domain.Usuario;

public interface UsuarioResource {

	@GetMapping(value = "/{id}")
	ResponseEntity<Usuario> findById(@PathVariable UUID id);
	
	@GetMapping(value = "/{cpf}")
	ResponseEntity<Usuario> findByCpf(@PathVariable String cpf);
	
	@GetMapping(value = "/{cnpj}")
	ResponseEntity<Usuario> findByCnpj(@PathVariable String cnpj);
	
	@GetMapping
	ResponseEntity<List<Usuario>> findAll();

}
