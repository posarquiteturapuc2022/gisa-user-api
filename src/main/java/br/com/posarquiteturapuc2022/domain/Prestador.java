package br.com.posarquiteturapuc2022.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "TB_PRESTADOR")
public class Prestador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Usuario usuario;
    private TipoPrestador tipoPrestador; 
    private boolean situacao;
}
