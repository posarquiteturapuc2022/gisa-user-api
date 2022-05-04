package br.com.posarquiteturapuc2022.domain;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.*;

import lombok.EqualsAndHashCode.Include;
import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "TB_CONSULTA")
public class Consulta {

    @Include
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    
    private String nome;
    private String descricao;

}
