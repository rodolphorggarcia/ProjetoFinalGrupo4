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

import br.com.projetofinal.beans.Musica;
import br.com.projetofinal.dao.MusicaDAO;

@RestController
@CrossOrigin("*")
public class MusicaController {
	
	@Autowired
	private MusicaDAO dao;
	
	@GetMapping("/totallancamento/{artista}")
	public ResponseEntity<Integer> getTotalLancamento(@PathVariable int artista){
		return ResponseEntity.ok(dao.findByTotalLancamento(artista));
	}
	
	@PostMapping("/novamusica")
	public ResponseEntity<Musica> gravar (@RequestBody Musica objeto){
		
		try{
			dao.save(objeto);
			return ResponseEntity.ok(objeto);
			
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}
	}
	
	@GetMapping("/musicas")
	public ResponseEntity<List<Musica>> getAll(){
		
		List<Musica> lista = (List<Musica>) dao.findAll();
		
		if(lista.size()==0) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);
		
	}
	
	@GetMapping("/musica/{cod}")
	public ResponseEntity<Musica> getMusica(@PathVariable int cod){
		
		Musica musica = dao.findById(cod).orElse(null);
		
		if(musica==null) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(musica);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
