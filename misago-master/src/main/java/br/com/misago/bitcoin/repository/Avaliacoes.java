package br.com.misago.bitcoin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.misago.bitcoin.model.Avaliacao;

public interface Avaliacoes extends JpaRepository<Avaliacao, Long> {

}
