package br.com.posarquiteturapuc2022.services;

import java.util.List;

import br.com.posarquiteturapuc2022.domain.Usuario;

public interface UsuarioService {

	Usuario findById(Long id);
	
	List<Usuario> findAll();
}
