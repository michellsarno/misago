package br.com.misago.bitcoin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.misago.bitcoin.model.Questao;
import br.com.misago.bitcoin.repository.Questoes;

@Service
public class QuestaoService {

	@Autowired
	Questoes questoes;
	
	public List<Questao> getTodasQuestoess() {
		return questoes.findAll();
	}

	public void salvar(Questao questao) {
		questoes.save(questao);
	}

	public Questao getQuestao(Long codigo) {
		return questoes.getOne(codigo);
	}

	public void excluir(Long codigo) {
		questoes.delete(codigo);
	}

}
