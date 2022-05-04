package br.com.posarquiteturapuc2022.domain;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.EqualsAndHashCode.Include;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "TB_ESPECIALIDADE")
public class Especialidade {
	
    @Include
	@Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private Consulta consulta;
    private Cirurgia cirurgia;
    
}
