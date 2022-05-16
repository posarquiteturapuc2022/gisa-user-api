package br.com.posarquiteturapuc2022.resources.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.posarquiteturapuc2022.domain.Usuario;
import br.com.posarquiteturapuc2022.resources.UsuarioResource;
import br.com.posarquiteturapuc2022.services.UsuarioService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/usuarios")
public class UsuarioResourceImpl implements UsuarioResource{

	private final UsuarioService userService;
	
	@Override
	public ResponseEntity<Usuario> findById(Long id) {
		return ResponseEntity.ok().body(userService.findById(id));
	}

	@Override
	public ResponseEntity<List<Usuario>> findAll() {
		return ResponseEntity.ok().body(userService.findAll());
	}

}
