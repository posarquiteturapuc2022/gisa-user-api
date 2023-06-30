package br.com.posarquiteturapuc2022.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.posarquiteturapuc2022.utils.EntityAbstract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode.Include;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PROFISSAO")
@Table(schema = "gisauserapidb")
@AttributeOverride(name = "id", column = @Column(name = "id_profissao"))
public class Profissao extends EntityAbstract implements Serializable, Comparable<Profissao> {

	private static final long serialVersionUID = 8020526587695386518L;

	@Include
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private UUID id;

	private String nome;

	@Override
	public int compareTo(Profissao o) {
		return  o.getCreatedAt().compareTo(getCreatedAt());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profissao other = (Profissao) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(id, nome);
		return result;
	}
	
}

