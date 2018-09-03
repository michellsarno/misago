package br.com.misago.bitcoin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.misago.bitcoin.enumerate.NivelHierarquico;
import br.com.misago.bitcoin.model.Colaborador;

public interface Colaboradores extends JpaRepository<Colaborador, Long> {

	
	List<Colaborador> findAllByNivelHierarquico(NivelHierarquico hierarquico);
	
}
