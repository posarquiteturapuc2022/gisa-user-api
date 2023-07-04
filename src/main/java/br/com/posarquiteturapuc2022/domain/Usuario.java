package br.com.posarquiteturapuc2022.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.posarquiteturapuc2022.domain.enums.NivelFormacao;
import br.com.posarquiteturapuc2022.domain.enums.TipoUsuario;
import br.com.posarquiteturapuc2022.utils.EntityAbstract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode.Include;
import lombok.NoArgsConstructor;

/**
 * @author alvar
 *
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
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
    private String email;
    
	@Column(unique = true, length = 20)
	private String cnpj;
	
	@Column(unique = true, length = 15)
	private String cpf;
	
    private String numeroSUS;
    
    private String sexo;
    private String cep;
    private String endereco;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;
    private String estadoCivil;
    
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private NivelFormacao nivelFormacao;

    private TipoUsuario tipoUsuario;
	
    @ManyToOne
	@JoinColumn(name = "id_profissao")
    private Profissao profissao;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    private String password;
    
	@Override
	public int compareTo(Usuario o) {
		return  o.getCreatedAt().compareTo(getCreatedAt());
	}

	@PrePersist
	public void prepersist() {
		this.setDataCadastro(LocalDate.now());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(cidade, other.cidade) && Objects.equals(cnpj, other.cnpj)
				&& Objects.equals(cpf, other.cpf) && Objects.equals(dataCadastro, other.dataCadastro)
				&& Objects.equals(dataNascimento, other.dataNascimento) && Objects.equals(email, other.email)
				&& Objects.equals(endereco, other.endereco) && Objects.equals(estadoCivil, other.estadoCivil)
				&& Objects.equals(id, other.id) 
				&& Objects.equals(nome, other.nome) && Objects.equals(numero, other.numero)
				&& Objects.equals(numeroSUS, other.numeroSUS) && Objects.equals(password, other.password)
				&& Objects.equals(profissao, other.profissao) && Objects.equals(sexo, other.sexo)
				&& tipoUsuario == other.tipoUsuario && Objects.equals(uf, other.uf);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(bairro, cep, cidade, cnpj, cpf, dataCadastro, dataNascimento, email,
				endereco, estadoCivil, id, nome, numero, numeroSUS, password, profissao, sexo,
				tipoUsuario, uf);
		return result;
	}

}
