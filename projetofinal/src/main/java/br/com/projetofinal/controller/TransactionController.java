package br.com.projetofinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.projetofinal.beans.Transaction;
import br.com.projetofinal.dao.TransactionDAO;

@RestController
@CrossOrigin("*")
public class TransactionController {
	
	
	@Autowired
	private TransactionDAO dao;
	
	
	
	@GetMapping("/totalsucesso/{agente}")
	public ResponseEntity<Integer> getTotalSucesso(@PathVariable int agente){
		return ResponseEntity.ok(dao.findByTotalSucesso(agente));
	}
	
	@GetMapping("/totalfalha/{agente}")
	public ResponseEntity<Integer> getTotalFalha(@PathVariable int agente){
		return ResponseEntity.ok(dao.findByTotalFalha(agente));
	}
	
	@GetMapping("/totalfraude/{agente}")
	public ResponseEntity<Integer> getTotalFraude(@PathVariable int agente){
		return ResponseEntity.ok(dao.findByTotalFraude(agente));
	}
	
	
	@PostMapping("/novatransacao")
	public ResponseEntity<Transaction> gravar (@RequestBody Transaction objeto){
		
		try{
			dao.save(objeto);
			return ResponseEntity.ok(objeto);
			
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}
	}
	
	
	
	@GetMapping("/transacoes")
	public ResponseEntity<List<Transaction>> getAll(){
		
		List<Transaction> lista = (List<Transaction>) dao.findAll();
		
		if(lista.size()==0) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);
		
	}
	
	
	@GetMapping("/transacao/{cod}")
	public ResponseEntity<Transaction> getTransaction(@PathVariable int cod){
		
		Transaction transacao = dao.findById(cod).orElse(null);
		
		if(transacao==null) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(transacao);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
