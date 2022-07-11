package br.com.posarquiteturapuc2022.services;

import java.util.List;
import java.util.UUID;

import br.com.posarquiteturapuc2022.domain.Usuario;

public interface UsuarioService {
	
	public Usuario findById(UUID id);
	
	public Usuario findByCpf(String cpf);
	
	public Usuario findByCnpj(String cnpj);

	public List<Usuario> findAll();
}
