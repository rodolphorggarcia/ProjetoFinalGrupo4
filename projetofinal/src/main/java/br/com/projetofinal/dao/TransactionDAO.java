package br.com.projetofinal.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.projetofinal.beans.Transaction;

public interface TransactionDAO extends CrudRepository<Transaction, Integer>{
	
	@Query(value="SELECT COUNT(*) AS TRANSACOES_SUCESSO FROM mtb310_transaction WHERE status=0 AND ag_financeiro_id_agente= :num", nativeQuery = true)
	int findByTotalSucesso(@Param("num") int num);
	
	@Query(value="SELECT COUNT(*) AS TRANSACOES_REJEITADAS FROM mtb310_transaction WHERE status=1 AND ag_financeiro_id_agente= :num", nativeQuery = true)
	int findByTotalFalha(@Param("num") int num);
	
	@Query(value="SELECT COUNT(*) AS TRANSACOES_FRAUDE FROM mtb310_transaction WHERE status=2 AND ag_financeiro_id_agente= :num", nativeQuery = true)
	int findByTotalFraude(@Param("num") int num);
	
	
	

}
