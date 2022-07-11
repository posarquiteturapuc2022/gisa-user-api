package br.com.posarquiteturapuc2022.utils;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.posarquiteturapuc2022.domain.UsuarioAbstract;
import br.com.posarquiteturapuc2022.resources.exceptions.AuthorizationException;

@Service
public class EntityAbstractListeners {

	@PrePersist
	public void beforeCreate(EntityAbstract obj) throws AuthorizationException {
		obj.setCreatedAt(new Date());
		try {
			obj.setCreatedBy(getUsuario().getId());
		} catch (Exception e) {
			//throw new AuthorizationException("Usuário não permitido");
		}
		obj.setUpdateAt(obj.getCreatedAt());
		obj.setUpdateBy(obj.getCreatedBy());
	}

	@PreUpdate
	public void beforeUpdate(EntityAbstract obj) throws AuthorizationException {
		try {
			obj.setUpdateBy(getUsuario().getId());
		} catch (Exception e) {
			//throw new AuthorizationException("Usuário não permitido");
		}
		obj.setUpdateAt(new Date());
	}

	private UsuarioAbstract getUsuario() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return (UsuarioAbstract) principal;
	}
}
