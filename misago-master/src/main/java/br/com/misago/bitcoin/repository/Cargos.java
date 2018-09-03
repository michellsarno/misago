package br.com.misago.bitcoin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.misago.bitcoin.model.Cargo;

public interface Cargos extends JpaRepository<Cargo, Long> {

}
