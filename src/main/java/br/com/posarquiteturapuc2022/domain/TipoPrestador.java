package br.com.posarquiteturapuc2022.domain;

public enum TipoPrestador {
	MEDICO(1, "Médico"), 
	CONSULTORIO(2, "Consultório"), 
	LABORATORIO(3, "Laboratório"), 
	CLINICA(4, "Clnica"), 
	HOSPITAL(5, "´Hospital");
	
	private Integer codigo;
	private String descricao;
	
	private TipoPrestador(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoPrestador toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(TipoPrestador x : TipoPrestador.values()) {
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Criticidade inválido");
	}

}
