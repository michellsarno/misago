package br.com.misago.bitcoin.enumerate;

public enum TipoQuestao {
	
	CAPACIDADE("Capacidade"),
	HABILIDADE("Habilidade"),
	ATITUDE("Atitude");
	
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	private TipoQuestao(String descricao) {
		this.descricao = descricao;
	}
}
