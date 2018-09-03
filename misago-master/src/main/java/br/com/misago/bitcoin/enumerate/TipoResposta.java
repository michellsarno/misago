package br.com.misago.bitcoin.enumerate;

public enum TipoResposta {
	
	OBJETIVA("Objetiva"),
	SUBJETIVA("Subjetiva");
	
	
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	private TipoResposta(String descricao) {
		this.descricao = descricao;
	}
	
	
}
