package br.com.posarquiteturapuc2022.domain;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.EqualsAndHashCode.Include;

import static javax.persistence.GenerationType.IDENTITY;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "TB_USUARIO")
public class Usuario {

    @Include
	@Id
	@GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String password;

}
