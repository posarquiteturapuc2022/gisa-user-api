package br.com.posarquiteturapuc2022.domain;

public enum TipoCobertura {
	NACIONAL(1, "Nacional"), 
	INTERNACIONAL(2, "Internacional");
	
	private Integer codigo;
	private String descricao;
	
	private TipoCobertura(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCobertura toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(TipoCobertura x : TipoCobertura.values()) {
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Criticidade inválido");
	}

}
