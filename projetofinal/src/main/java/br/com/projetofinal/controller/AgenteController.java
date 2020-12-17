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

import br.com.projetofinal.beans.Agente;
import br.com.projetofinal.dao.AgenteDAO;

@RestController
@CrossOrigin("*")
public class AgenteController {
	
	
	
	@Autowired
	private AgenteDAO dao;
	
	@GetMapping("/")
	public ResponseEntity <String> home(){
		return ResponseEntity.ok("Seja bem vindo!!");
	}
	
	@GetMapping("/agente/{cod}" )
	public  ResponseEntity <Agente> getAgente(@PathVariable int cod) {
		Agente agente = dao.findById(cod).orElse(null);
		if(agente==null) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(agente);
	}
	
	@GetMapping("/agentes")
	public ResponseEntity<List<Agente>> getAll(){
		List<Agente> lista = (List<Agente>)dao.findAll();
		if (lista.size()==0) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);
	} 
	
	
	@PostMapping("/agentepost")
	public ResponseEntity<Agente> getAgentePost(@RequestBody Agente objeto){
		Agente resposta = dao.findById(objeto.getId_agente()).orElse(null);
		if(resposta==null) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(resposta);
	}
	
	
	@GetMapping("/apagaragente/{cod}")
	public void apagarAgente(@PathVariable int cod) {
		try {
			dao.deleteById(cod);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	

}
