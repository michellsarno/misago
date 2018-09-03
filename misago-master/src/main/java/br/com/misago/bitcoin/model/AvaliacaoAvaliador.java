package br.com.misago.bitcoin.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.misago.bitcoin.enumerate.NivelHierarquico;
import br.com.misago.bitcoin.enumerate.TipoSelecao;

@Entity
public class AvaliacaoAvaliador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Enumerated(EnumType.STRING)
	private NivelHierarquico nivelAvaliado;
	
	@Enumerated(EnumType.STRING)
	private NivelHierarquico nivelAvaliador;
	
	@Enumerated(EnumType.STRING)
	private TipoSelecao tipoSelecao;
	
	private int quantidadeAvaliadores;

	private int pesoAvaliador;

	@ManyToOne
	@JoinColumn(name="avaliacao_id")
	private Avaliacao avaliacao;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public NivelHierarquico getNivelAvaliado() {
		return nivelAvaliado;
	}

	public void setNivelAvaliado(NivelHierarquico nivelAvaliado) {
		this.nivelAvaliado = nivelAvaliado;
	}

	public NivelHierarquico getNivelAvaliador() {
		return nivelAvaliador;
	}

	public void setNivelAvaliador(NivelHierarquico nivelAvaliador) {
		this.nivelAvaliador = nivelAvaliador;
	}

	public TipoSelecao getTipoSelecao() {
		return tipoSelecao;
	}

	public void setTipoSelecao(TipoSelecao tipoSelecao) {
		this.tipoSelecao = tipoSelecao;
	}

	public int getQuantidadeAvaliadores() {
		return quantidadeAvaliadores;
	}

	public void setQuantidadeAvaliadores(int quantidadeAvaliadores) {
		this.quantidadeAvaliadores = quantidadeAvaliadores;
	}

	public int getPesoAvaliador() {
		return pesoAvaliador;
	}

	public void setPesoAvaliador(int pesoAvaliador) {
		this.pesoAvaliador = pesoAvaliador;
	}

	@Override
	public String toString() {
		return "AvaliacaoAvaliador [codigo=" + codigo + ", avaliacao=" + getAvaliacao() + ", nivelAvaliado=" + nivelAvaliado
				+ ", nivelAvaliador=" + nivelAvaliador + ", tipoSelecao=" + tipoSelecao + ", quantidadeAvaliadores="
				+ quantidadeAvaliadores + ", pesoAvaliador=" + pesoAvaliador + "]";
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	
	
	
}
