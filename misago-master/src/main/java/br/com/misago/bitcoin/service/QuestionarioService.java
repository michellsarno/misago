package br.com.misago.bitcoin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.misago.bitcoin.model.Questionario;
import br.com.misago.bitcoin.repository.Questionarios;

@Service
public class QuestionarioService {

	@Autowired
	Questionarios questionarios;
	
	public List<Questionario> getTodosQuestionarios() {
		return questionarios.findAll();
	}

	public void salvar(Questionario questionario) {
		questionarios.save(questionario);
	}

	public Questionario getQuestionario(Long codigo) {
		return questionarios.getOne(codigo);
	}

	public void excluir(Long codigo) {
		questionarios.delete(codigo);
	}

}
