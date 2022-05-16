package br.com.posarquiteturapuc2022.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.posarquiteturapuc2022.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
