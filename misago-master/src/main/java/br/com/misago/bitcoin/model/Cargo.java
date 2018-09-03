package br.com.misago.bitcoin.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import br.com.misago.bitcoin.enumerate.NivelHierarquico;

@Entity
public class Cargo {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private NivelHierarquico nivelHierarquico;
	
	@ManyToMany(cascade ={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Questionario> questionario;
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public NivelHierarquico getNivelHierarquico() {
		return nivelHierarquico;
	}

	public void setNivelHierarquico(NivelHierarquico nivelHierarquico) {
		this.nivelHierarquico = nivelHierarquico;
	}

	public List<Questionario> getQuestionario() {
		return questionario;
	}

	public void setQuestionario(List<Questionario> questionario) {
		this.questionario = questionario;
	}
		
}
