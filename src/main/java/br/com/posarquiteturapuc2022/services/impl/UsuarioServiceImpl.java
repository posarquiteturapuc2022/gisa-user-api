package br.com.posarquiteturapuc2022.services.impl;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.posarquiteturapuc2022.domain.Usuario;
import br.com.posarquiteturapuc2022.domain.enums.TipoUsuario;
import br.com.posarquiteturapuc2022.repositories.UsuarioRepository;
import br.com.posarquiteturapuc2022.resources.exceptions.CpfCnpjUsuarioException;
import br.com.posarquiteturapuc2022.resources.exceptions.TipoUsuarioException;
import br.com.posarquiteturapuc2022.resources.exceptions.UsuarioCadastradoException;
import br.com.posarquiteturapuc2022.services.UsuarioService;
import br.com.posarquiteturapuc2022.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	private final Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	private final UsuarioRepository usuarioRepository;
	
	private Usuario usuarioRetorno = new Usuario();
	
	private boolean flagUsuario = false;
	
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
	
	@SuppressWarnings("static-access")
	@Override
	public Usuario save(Usuario usuario) {
		if(!usuario.getCpf().isEmpty() || !usuario.getCnpj().isEmpty()) {
			if(!usuario.getCpf().isEmpty()) {
				this.flagUsuario = usuarioRepository.findByCpf(usuario.getCpf()).isPresent();
			}

			if(!usuario.getCnpj().isEmpty()) {
				this.flagUsuario = usuarioRepository.findByCnpj(usuario.getCnpj()).isPresent();
			}
		} else {
			logger.info("Informe um Usuário para o sistema!");
			throw new TipoUsuarioException("Informe um Usuário para o sistema!");
		}
			
		if (flagUsuario) {
			logger.info("Usuário cadastrado!");
			throw new UsuarioCadastradoException("Usuário cadastrado!");
		}else {
			validaCampos(usuario);
			
			this.usuarioRetorno.setNome(usuario.getNome());
			this.usuarioRetorno.setEmail(usuario.getEmail());
			
			if (!usuario.getCpf().isEmpty()) {
				if (!usuario.getCpf().isEmpty() && usuario.getTipoUsuario().getCodigo().equals(TipoUsuario.ASSOCIADO.getCodigo())) {
					this.usuarioRetorno.setCpf(usuario.getCpf());
					this.usuarioRetorno.setCnpj(null);
					this.usuarioRetorno.setNumeroSUS(usuario.getNumeroSUS());
					this.usuarioRetorno.setSexo(usuario.getSexo());
					this.usuarioRetorno.setEstadoCivil(usuario.getEstadoCivil());
					this.usuarioRetorno.setNivelFormacao(usuario.getNivelFormacao());
					this.usuarioRetorno.setProfissao(usuario.getProfissao());
					this.usuarioRetorno.setCreatedAt(usuario.getCreatedAt());
					this.usuarioRetorno.setPassword(passwordEncoder.encode(usuario.getPassword()));
				}else {
					logger.info("O Tipo de Usuário informado não pode ser salvo como Associado!");
					throw new TipoUsuarioException("O Tipo de Usuário informado não pode ser salvo como Associado!");
				}
			}else if (!usuario.getCnpj().isEmpty()) {
				if (!usuario.getCnpj().isEmpty() 
						&& (usuario.getTipoUsuario().getCodigo().equals(TipoUsuario.CONVENIADO.getCodigo()) 
								|| usuario.getTipoUsuario().getCodigo().equals(TipoUsuario.PRESTADOR.getCodigo()))) {
					this.usuarioRetorno.setCnpj(usuario.getCnpj());
					this.usuarioRetorno.setCpf(null);
				}else {
					logger.info("O Tipo de Usuário informado não pode ser salvo como Prestador ou Conveniado!");
					throw new TipoUsuarioException("O Tipo de Usuário não pode ser salvo como Prestador ou Conveniado!");
				}
			}
			
			this.usuarioRetorno.setEmail(usuario.getEmail());
			this.usuarioRetorno.setTipoUsuario(usuario.getTipoUsuario());
			this.usuarioRetorno.setCep(usuario.getCep());
			this.usuarioRetorno.setEndereco(usuario.getEndereco());
			this.usuarioRetorno.setNumero(usuario.getNumero());
			this.usuarioRetorno.setBairro(usuario.getBairro());
			this.usuarioRetorno.setCidade(usuario.getCidade());
			this.usuarioRetorno.setUf(usuario.getUf());
			return usuarioRepository.save(this.usuarioRetorno);
		}
	}

	@Override
	public Usuario update(Usuario usuario) {
		validaCampos(usuario);
		
		this.usuarioRetorno.setNome(usuario.getNome());
		this.usuarioRetorno.setEmail(usuario.getEmail());
		
		if (!usuario.getCpf().isEmpty() && usuario.getCnpj().isEmpty()) {
			if (!usuario.getCpf().isEmpty() && usuario.getTipoUsuario().getCodigo().equals(TipoUsuario.ASSOCIADO.getCodigo())) {
				this.usuarioRetorno.setCpf(usuario.getCpf());
				this.usuarioRetorno.setCnpj(null);
				this.usuarioRetorno.setNumeroSUS(usuario.getNumeroSUS());
				this.usuarioRetorno.setSexo(usuario.getSexo());
				this.usuarioRetorno.setEstadoCivil(usuario.getEstadoCivil());
				this.usuarioRetorno.setNivelFormacao(usuario.getNivelFormacao());
				this.usuarioRetorno.setProfissao(usuario.getProfissao());
				this.usuarioRetorno.setCreatedAt(usuario.getCreatedAt());
				this.usuarioRetorno.setPassword(passwordEncoder.encode(usuario.getPassword()));
			}else {
				logger.info("O Tipo de Usuário informado esta divergente do Associado!");
				throw new TipoUsuarioException("O Tipo de Usuário informado esta divergente do Associado!");
			}
		}else {
			if (usuario.getCnpj().isEmpty() 
					&& (usuario.getTipoUsuario().getCodigo().equals(TipoUsuario.CONVENIADO.getCodigo()) 
							|| usuario.getTipoUsuario().getCodigo().equals(TipoUsuario.PRESTADOR.getCodigo()))) {
				this.usuarioRetorno.setCnpj(usuario.getCnpj());
				this.usuarioRetorno.setCpf(null);
			}else {
				logger.info("O Tipo de Usuário informado esta divergente do Prestador ou Conveniado!");
				throw new TipoUsuarioException("O Tipo de Usuário informado esta divergente do Prestador ou Conveniado!");
			}
		}
		
		this.usuarioRetorno.setTipoUsuario(usuario.getTipoUsuario());
		this.usuarioRetorno.setNumeroSUS(usuario.getNumeroSUS());
		this.usuarioRetorno.setSexo(usuario.getSexo());
		this.usuarioRetorno.setCep(usuario.getCep());
		this.usuarioRetorno.setEndereco(usuario.getEndereco());
		this.usuarioRetorno.setNumero(usuario.getNumero());
		this.usuarioRetorno.setBairro(usuario.getBairro());
		this.usuarioRetorno.setCidade(usuario.getCidade());
		this.usuarioRetorno.setUf(usuario.getUf());
		this.usuarioRetorno.setEstadoCivil(usuario.getEstadoCivil());
		this.usuarioRetorno.setNivelFormacao(usuario.getNivelFormacao());
		this.usuarioRetorno.setProfissao(usuario.getProfissao());
		this.usuarioRetorno.setPassword(passwordEncoder.encode(usuario.getPassword()));
		return usuarioRepository.saveAndFlush(usuarioRetorno);
	}

	@Override
	public void delete(UUID id) {
		Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado!"));
		usuarioRepository.delete(usuario);
	}

	private void validaCampos(Usuario usuario) {
		if (usuario.getNome().isEmpty()) {
			logger.info("O Nome está vazio!");
			throw new CpfCnpjUsuarioException("O Nome está vazio!");
		}
		
		if (usuario.getCpf().isEmpty() && usuario.getCnpj().isEmpty()) {
			logger.info("O CNPJ/CPF está vazio!");
			throw new CpfCnpjUsuarioException("O CNPJ/CPF está vazio!");
		}
		
		if (usuario.getEmail().isEmpty()) {
			logger.info("O Email está vazio!");
			throw new CpfCnpjUsuarioException("O Email está vazio!");
		}
	}
}
