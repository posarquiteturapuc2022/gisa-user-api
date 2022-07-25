package br.com.posarquiteturapuc2022.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.posarquiteturapuc2022.domain.Usuario;

@Service
public interface UsuarioService {
	
	public Usuario findById(UUID id);
	
	public Usuario findByCpf(String cpf);

	public Usuario findByCnpj(String cnpj);

	public List<Usuario> findAll();
	
	public Usuario save(Usuario prestador);

	public Usuario update(Usuario usuario);

	public void delete(UUID id);
}
