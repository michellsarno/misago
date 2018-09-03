package br.com.misago.bitcoin.enumerate;

public enum TipoSelecao {
	
	ALEATORIA("Aleatória"),
	AUTO_AVALIACAO("Auto-Avaliação");
	
	private String descricao;

	private TipoSelecao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
