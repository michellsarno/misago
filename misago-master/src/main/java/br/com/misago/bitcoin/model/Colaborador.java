package br.com.misago.bitcoin.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.misago.bitcoin.enumerate.NivelHierarquico;

@Entity
public class Colaborador {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String nome;
	private String email;
	
	@Enumerated(EnumType.STRING)
	private NivelHierarquico nivelHierarquico;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public NivelHierarquico getNivelHierarquico() {
		return nivelHierarquico;
	}
	public void setNivelHierarquico(NivelHierarquico nivelHierarquico) {
		this.nivelHierarquico = nivelHierarquico;
	}
	@Override
	public String toString() {
		return "Colaborador [codigo=" + codigo + ", nome=" + nome + ", email=" + email + ", nivelHierarquico="
				+ nivelHierarquico + "]";
	}
	
	
	

	
	
}
