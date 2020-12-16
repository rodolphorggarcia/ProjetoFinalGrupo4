package br.com.projetofinal.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.projetofinal.beans.Transaction;

public interface TransactionDAO extends CrudRepository<Transaction, Integer>{

}
