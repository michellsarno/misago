package br.com.misago.bitcoin.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.misago.bitcoin.enumerate.NivelHierarquico;
import br.com.misago.bitcoin.enumerate.TipoSelecao;
import br.com.misago.bitcoin.model.Avaliacao;
import br.com.misago.bitcoin.model.AvaliacaoAvaliador;
import br.com.misago.bitcoin.model.Colaborador;
import br.com.misago.bitcoin.repository.Avaliacoes;

@Service
public class AvaliacaoService {
	
	@Autowired
	private Avaliacoes avaliacoes;
	@Autowired
	private ColaboradorService colaboradorService;

	public void salvar(Avaliacao avaliacao) {
		avaliacoes.save(avaliacao);
	}

	public List<Avaliacao> getTodasAvaliacoes() {
		return avaliacoes.findAll();
	}

	public Avaliacao getAvaliacao(Long codigo) {
		Avaliacao findOne = avaliacoes.findOne(codigo);
		
		return findOne;
	}

	public void excluir(Long codigo) {

		avaliacoes.delete(codigo);
		
	}

	public void gerarAvaliacao(Long codigo) {

		Avaliacao avaliacao = avaliacoes.getOne(codigo);
		
		
		List<AvaliacaoAvaliador> detalhes = avaliacao.getDetalhes();
		
		for (AvaliacaoAvaliador avaliacaoAvaliador : detalhes) {

			int quantidadeAvaliadores = avaliacaoAvaliador.getQuantidadeAvaliadores();
			NivelHierarquico nivelAvaliado = avaliacaoAvaliador.getNivelAvaliado();
			NivelHierarquico nivelAvaliador = avaliacaoAvaliador.getNivelAvaliador();

			TipoSelecao tipoSelecao = avaliacaoAvaliador.getTipoSelecao();

			System.out.println(tipoSelecao.getDescricao().toUpperCase());
			
			List<Colaborador> colaboradoresAvaliados = colaboradorService.getColaboradorPeloNivel(nivelAvaliado);
			
			for (Colaborador colaborador : colaboradoresAvaliados) {

				List<Colaborador> avaliadores = getAvaliadores(quantidadeAvaliadores, nivelAvaliador, colaborador, tipoSelecao);
				
				for (Colaborador avaliador : avaliadores) {
					System.out.println(">>>> "+avaliador.getNome()+" avalia "+colaborador.getNome());
				}
			}
			
		}
		
	}

	private List<Colaborador> getAvaliadores(int quantidadeAvaliadores, NivelHierarquico nivelAvaliador, Colaborador colaborador, TipoSelecao tipoSelecao) {
		
		if (TipoSelecao.AUTO_AVALIACAO.equals(tipoSelecao)) {
			return Arrays.asList(colaborador);
		}
		
		List<Colaborador> avaliadores = colaboradorService.getColaboradorPeloNivel(nivelAvaliador);
		
		avaliadores.remove(colaborador);
		
		int size = avaliadores.size();
		
		if(quantidadeAvaliadores > size){
			quantidadeAvaliadores = size;
		}
		
		Collections.shuffle(avaliadores);
		
		return avaliadores.subList(0, quantidadeAvaliadores);
	}
	
}
