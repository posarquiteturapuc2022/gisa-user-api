package br.com.posarquiteturapuc2022.resources.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.posarquiteturapuc2022.domain.Usuario;
import br.com.posarquiteturapuc2022.resources.UsuarioResource;
import br.com.posarquiteturapuc2022.services.UsuarioService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/api/usuarios")
public class UsuarioResourceImpl implements UsuarioResource {

	private final UsuarioService userService;

	@Override
	public ResponseEntity<Usuario> findById(UUID id) {
		return ResponseEntity.ok().body(userService.findById(id));
	}

	@Override
	public ResponseEntity<List<Usuario>> findAll() {
		return ResponseEntity.ok().body(userService.findAll());
	}

	@Override
	public ResponseEntity<Usuario> findByCpf(String cpf) {
		return ResponseEntity.ok().body(userService.findByCpf(cpf));
	}
	
	@Override
	public ResponseEntity<Usuario> findByCnpj(String cnpj) {
		return ResponseEntity.ok().body(userService.findByCnpj(cnpj));
	}

	@Override
	public ResponseEntity<Usuario> save(Usuario usuario) {
		return ResponseEntity.ok().body(userService.save(usuario));
	}

	@Override
	public ResponseEntity<Usuario> update(Usuario usuario) {
		return ResponseEntity.ok().body(userService.update(usuario));
	}

	@Override
	public ResponseEntity<Void> delete(@PathVariable UUID id) {
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}

	//Observação: todo o processo de integração entre as diferentes 
	//tecnologias e aplicações existentes, deve prover transparência, 
	//alta disponibilidade e robustez. Deve-se fazer uso de middlewares adequados, 
	//tais como: Remote Procedure Call (RPC), 
	//serviços de mensageria, web sockets, protocolos como HTTP, 
	//TCP/IP, SOAP, Rest, GraphQL etc. 
	//A escolha das tecnologias deve basear-se preferencialmente em produtos das empresas 
	//Apache e Red Hat, que possuem expertise para este tipo de solução.
}