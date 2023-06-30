package br.com.posarquiteturapuc2022.domain.enums;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoUsuario implements Serializable { 
	ASSOCIADO(1, "Associado"), 
	PRESTADOR(2, "Prestador"),
	CONVENIADO(3, "Conveniado");
	
//	ASSOCIADO(1, "Associado"), //0
//	PRESTADOR(2, "Prestador"), //1
//	CONVENIADO(3, "Conveniado"); //2
	
	private Integer codigo;
	private String descricao;
	
	private TipoUsuario(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoUsuario toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(TipoUsuario x : TipoUsuario.values()) {
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Tipo Usuário inválido");
	}

}
