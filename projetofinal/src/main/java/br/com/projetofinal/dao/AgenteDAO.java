package br.com.projetofinal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.projetofinal.beans.Agente;

public interface AgenteDAO extends CrudRepository<Agente, Integer>{
	
	@Query(value="SELECT * FROM mtb310_ag_financeiro ORDER BY volume_transacional DESC", nativeQuery = true)
	List<Agente> getAgenteOrder();
	
}
