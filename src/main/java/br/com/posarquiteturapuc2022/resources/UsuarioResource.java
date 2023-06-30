package br.com.posarquiteturapuc2022.resources;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.posarquiteturapuc2022.domain.Usuario;

public interface UsuarioResource {
	
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	ResponseEntity<Usuario> findById(@PathVariable UUID id);

	@RequestMapping(value = "/cpf/{cpf}", method = RequestMethod.GET)
	ResponseEntity<Usuario> findByCpf(@PathVariable String cpf);
	
	@RequestMapping(value = "/cnpj/{cnpj}", method = RequestMethod.GET)
	ResponseEntity<Usuario> findByCnpj(@PathVariable  String cnpj);
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<Usuario>> findAll();
	
	@PostMapping
	ResponseEntity<Usuario> save(@RequestBody Usuario usuario);

	@PutMapping
	ResponseEntity<Usuario> update(@RequestBody Usuario usuario);

	@DeleteMapping(value = "/delete/{id}")
	ResponseEntity<Void> delete(@PathVariable UUID id);
}