package br.com.posarquiteturapuc2022.domain;

import lombok.*;

import javax.persistence.*;

import br.com.posarquiteturapuc2022.domain.enums.TipoPrestador;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.EqualsAndHashCode.Include;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "TB_CONVENIADO")
public class Conveniado {
	
    @Include
	@Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private Usuario usuario;
    private TipoPrestador tipoPrestador; 
    private Especialidade especialidade; 
    private boolean situacao;
}
