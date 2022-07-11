package br.com.posarquiteturapuc2022.domain;


import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.posarquiteturapuc2022.utils.EntityAbstract;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "gisauserapidb")
@AttributeOverride(name = "id", column = @Column(name = "id_usuario"))
public class Usuario extends EntityAbstract implements Serializable, Comparable<Usuario>{
	
	private static final long serialVersionUID = 5251545892116372470L;
	
	@Include
	@Id
	@GeneratedValue(strategy = IDENTITY)
    private UUID id;
    private String nome;
    private String cpf;
    private String cnpj;
    private String email;
    private String password;
    
	protected Usuario(UUID id, String cpf) {
		super();
		this.id = id;
		this.cpf = cpf;
	}
    
	@Override
	public int compareTo(Usuario o) {
		return  o.getCreatedAt().compareTo(getCreatedAt());
	}
}
