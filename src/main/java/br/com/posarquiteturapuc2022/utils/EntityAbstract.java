package br.com.posarquiteturapuc2022.utils;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@EntityListeners(EntityAbstractListeners.class)
@MappedSuperclass
public abstract class EntityAbstract implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id", updatable = false)
	private UUID id;
	private UUID createdBy;
	private UUID updateBy;
	private Date createdAt;
	private Date updateAt;
	private Boolean deteled = false;

	protected EntityAbstract() {
	}

	protected EntityAbstract(UUID id) {
		super();
		this.id = id;
	}

	protected EntityAbstract(UUID id, UUID createdBy, UUID updateBy, Date createdAt, Date updateAt) {
		super();
		this.id = id;
		this.createdBy = createdBy;
		this.updateBy = updateBy;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
	}

	@Override
	public int hashCode() {
		final var prime = 31;
		var result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntityAbstract other = (EntityAbstract) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UUID createdBy) {
		this.createdBy = createdBy;
	}

	public UUID getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(UUID updateBy) {
		this.updateBy = updateBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public Boolean getDeteled() {
		return deteled;
	}

	public void setDeteled(Boolean deteled) {
		this.deteled = deteled;
	}
}

