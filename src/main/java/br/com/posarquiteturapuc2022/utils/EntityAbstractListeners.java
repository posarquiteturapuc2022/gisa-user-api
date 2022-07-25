package br.com.posarquiteturapuc2022.utils;

import java.time.LocalDate;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.stereotype.Service;

import br.com.posarquiteturapuc2022.resources.exceptions.AuthorizationException;

@Service
public class EntityAbstractListeners {

	@PrePersist
	public void beforeCreate(EntityAbstract obj) throws AuthorizationException {
		obj.setCreatedAt(LocalDate.now());
		obj.setUpdateAt(obj.getCreatedAt());
	}

	@PreUpdate
	public void beforeUpdate(EntityAbstract obj) throws AuthorizationException {
		obj.setUpdateAt(LocalDate.now());
	}

}
