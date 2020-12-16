package br.com.projetofinal.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.projetofinal.beans.Usuario;

/*
 * Design Patter => DAO = > Data Access Object
 * O DAO é uma classe/interface que é responsavel pelo CRUD.
 * 
 * C => Create - insert
 * R => Read - select
 * U => Update - update
 * D => Delete - delete
 * */

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{
	
	/*
	 * save() = > gravar ou alterar um registro/linha da tabela.
	 * findById() = > pesquisar pela chave primaria
	 * findAll() => pesquisar todos
	 * deleteById() = > apaga pelo ID
 	 * deleteAll() = > apaga todas as linhas da tabela
 	 * 
 	 * */
	
	public Usuario findByEmailAndSenha(String email, String senha);
	
}


