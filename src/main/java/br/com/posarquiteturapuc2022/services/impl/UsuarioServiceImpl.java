package br.com.posarquiteturapuc2022.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.posarquiteturapuc2022.domain.Usuario;
import br.com.posarquiteturapuc2022.repositories.UsuarioRepository;
import br.com.posarquiteturapuc2022.services.UsuarioService;
import br.com.posarquiteturapuc2022.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService{

	private final UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario findById(UUID id) {
		return usuarioRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado!"));
	}
	
	@Override
	public Usuario findByCpf(String cpf) {
		return usuarioRepository.findByCpf(cpf).orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado!"));
	}
	
	@Override
	public Usuario findByCnpj(String cnpj) {
		return usuarioRepository.findByCnpj(cnpj).orElseThrow(() -> new ObjectNotFoundException("Prestador não encontrado!"));
	}

	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario update(Usuario usuario) {
		return usuarioRepository.saveAndFlush(usuario);
	}

	@Override
	public void delete(UUID id) {
		Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado!"));
		usuarioRepository.delete(usuario);
	}
}
