package br.com.posarquiteturapuc2022.domain;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.*;

import lombok.*;
import lombok.EqualsAndHashCode.Include;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "TB_CIRURGIA")
public class Cirurgia {

    @Include
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    
    private String nome;
    private String descricao;


}
