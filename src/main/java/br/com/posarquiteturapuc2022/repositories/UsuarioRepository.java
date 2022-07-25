package br.com.posarquiteturapuc2022.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.posarquiteturapuc2022.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID>{

	@Transactional(readOnly = true)
	@Query(value = "SELECT u FROM Usuario u WHERE u.cpf =:cpf")
	public Optional<Usuario> findByCpf(@Param("cpf") String cpf);

	@Transactional(readOnly = true)
	@Query(value = "SELECT u FROM Usuario u WHERE u.cnpj =:cnpj")
	public Optional<Usuario> findByCnpj(@Param("cnpj") String cnpj);
	
	
}
