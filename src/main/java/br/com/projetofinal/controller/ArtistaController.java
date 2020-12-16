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

import br.com.projetofinal.beans.Artista;
import br.com.projetofinal.dao.ArtistaDAO;


@RestController
@CrossOrigin("*")
public class ArtistaController {

	
	@Autowired
	private ArtistaDAO dao;
	
	@GetMapping("/artista/{cod}" )
	public  ResponseEntity <Artista> getUser(@PathVariable int cod) {
		Artista artista = dao.findById(cod).orElse(null);
		if(artista==null) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(artista);
	}
	
	@GetMapping("/artistas")
	public ResponseEntity<List<Artista>> getAll(){
		List<Artista> lista = (List<Artista>)dao.findAll();
		if (lista.size()==0) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);
	} 
	
	@PostMapping("/artistapost")
	public ResponseEntity<Artista> getArtistaPost(@RequestBody Artista objeto){
		Artista resposta = dao.findById(objeto.getId()).orElse(null);
		if(resposta==null) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(resposta);
	}
	
	
	@GetMapping("/apagarartista/{cod}")
	public void apagarArtista(@PathVariable int cod) {
		try {
			dao.deleteById(cod);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}		
	/*@PostMapping("/artista/delete")
	public ResponseEntity <Artista> delteArtistaId(@RequestBody Artista objeto){
		Artista resposta = dao.deleteById(objeto);
		return resposta;
	}
	
	
	

	
	@DeleteMapping("/artista/delete/{id}")
	 public void deleteArtista(@PathVariable int id) {
	    dao.deleteById(id);
	  }
	
	@RequestMapping(value="artista/delete/1",  method=RequestMethod.POST)
	 public String deleteArtista(@RequestParam int id) {
	    dao.deleteById(id);
	    return "Deu certo";
	  }*/


	
	
	
	
	
	
	
