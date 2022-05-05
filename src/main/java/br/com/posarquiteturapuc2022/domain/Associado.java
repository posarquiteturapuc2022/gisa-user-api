package br.com.posarquiteturapuc2022.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.posarquiteturapuc2022.domain.enums.Perfil;
import br.com.posarquiteturapuc2022.domain.enums.TipoCategoria;
import br.com.posarquiteturapuc2022.domain.enums.TipoCobertura;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "TB_ASSOCIADO")
public class Associado {

    @Include
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private Usuario usuario;
    private Integer idade;
    private Integer codigoPlano;
    private BigDecimal valorPlanoMensal;
	private TipoCobertura tipoCobertura;
	private TipoCategoria tipoCategoria;
    private boolean odontologico;
    
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "PERFIS")
	protected Set<Integer> perfis = new HashSet<>();
    private boolean situacao;

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		this.perfis.add(perfil.getCodigo());
	}

	public void planoOdontologico(boolean planoOdontologico, BigDecimal valorPlano) {
		if (planoOdontologico) {
			setValorPlanoMensal(valorPlano);
	        NumberFormat df2 = NumberFormat.getInstance();
	        BigDecimal percent15 = new BigDecimal ("0.15");
	        System.out.println("Valor Fixo do Plano: " + getValorPlanoMensal());
	        System.out.println ("15% de Valor do Plano Mensal: " + df2.format(getValorPlanoMensal().multiply(percent15)).replace(",","."));
	        BigDecimal vpm = new BigDecimal(String.valueOf(df2.format(getValorPlanoMensal().multiply(percent15)).replace(",",".")));
			setValorPlanoMensal(valorPlano.add(vpm));
			System.out.println("setValorPlanoMensal(): " + valorPlano.add(vpm));
		}
	}
}
