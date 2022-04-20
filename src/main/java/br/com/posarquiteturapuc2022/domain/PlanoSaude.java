package br.com.posarquiteturapuc2022.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "TB_PLANO_SAUDE")
public class PlanoSaude {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String nome;
    private String email;
	private TipoPrestador tipoPrestador;
	private TipoCobertura tipoCobertura;
	private boolean situacao;
}
