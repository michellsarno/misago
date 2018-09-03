package br.com.misago.bitcoin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AvaliacaoDetalhe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private Long codigoAvaliacao;
	private Long codigoAvaliador;
	private Long codigoAvaliado;
	private Long codigoQuestao;
	private float pontos;
	
	public Long getCodigoAvaliacao() {
		return codigoAvaliacao;
	}
	public void setCodigoAvaliacao(Long codigoAvaliacao) {
		this.codigoAvaliacao = codigoAvaliacao;
	}
	public Long getCodigoAvaliador() {
		return codigoAvaliador;
	}
	public void setCodigoAvaliador(Long codigoAvaliador) {
		this.codigoAvaliador = codigoAvaliador;
	}
	public Long getCodigoAvaliado() {
		return codigoAvaliado;
	}
	public void setCodigoAvaliado(Long codigoAvaliado) {
		this.codigoAvaliado = codigoAvaliado;
	}
	public Long getCodigoQuestao() {
		return codigoQuestao;
	}
	public void setCodigoQuestao(Long codigoQuestao) {
		this.codigoQuestao = codigoQuestao;
	}
	public float getPontos() {
		return pontos;
	}
	public void setPontos(float pontos) {
		this.pontos = pontos;
	}

}
