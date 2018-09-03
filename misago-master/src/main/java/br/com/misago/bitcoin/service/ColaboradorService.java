package br.com.misago.bitcoin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.misago.bitcoin.enumerate.NivelHierarquico;
import br.com.misago.bitcoin.model.Colaborador;
import br.com.misago.bitcoin.repository.Colaboradores;

@Service
public class ColaboradorService {

	@Autowired
	Colaboradores colaboradores;
	
	public List<Colaborador> getTodosColaboradores() {
		return colaboradores.findAll();
	}

	public Colaborador getColaborador(Long codigo) {
		return colaboradores.getOne(codigo);
	}

	public void excluir(Long codigo) {
		colaboradores.delete(codigo);
	}

	public void salvar(Colaborador colaborador) {
		colaboradores.save(colaborador);
	}

	public List<Colaborador> getColaboradorPeloNivel(NivelHierarquico nivelHierarquico) {
		return colaboradores.findAllByNivelHierarquico(nivelHierarquico);
	}

}
