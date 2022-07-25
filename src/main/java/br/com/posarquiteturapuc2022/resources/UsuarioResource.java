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
import org.springframework.web.bind.annotation.RequestParam;

import br.com.posarquiteturapuc2022.domain.Usuario;

public interface UsuarioResource {
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ResponseEntity<Usuario> findById(@RequestParam(value="id") UUID id);

	@RequestMapping(value = "/{cpf}", method = RequestMethod.GET)
	ResponseEntity<Usuario> findByCpf(@RequestParam(value="cpf") String cpf);
	
	@RequestMapping(value = "/{cnpj}", method = RequestMethod.GET)
	ResponseEntity<Usuario> findByCnpj(@RequestParam(value="cnpj")  String cnpj);
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<Usuario>> findAll();
	
	@PostMapping
	ResponseEntity<Usuario> save(@RequestBody Usuario usuario);

	@PutMapping
	ResponseEntity<Usuario> update(@RequestBody Usuario usuario);

	@DeleteMapping(value = "/{id}")
	ResponseEntity<Void> delete(@PathVariable UUID id);
	
}
