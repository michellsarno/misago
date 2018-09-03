package br.com.misago.bitcoin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.misago.bitcoin.model.Questao;

public interface Questoes extends JpaRepository<Questao, Long> {

}
