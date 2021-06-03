package com.lojaGames.db_lojaGames.TipoController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojaGames.db_lojaGames.model.Tipo;
import com.lojaGames.db_lojaGames.repository.Tipo_Repository;


@RestController
@RequestMapping("/tipo")
@CrossOrigin("*")
public class TipoController {
	
	@Autowired
	private Tipo_Repository TipoRepository;
	
	@GetMapping
	public ResponseEntity<List<Tipo>> getAll(){
		return ResponseEntity.ok(TipoRepository.findAll());
	}
		@GetMapping("/{id}")
		public ResponseEntity<Tipo> Sacana(@PathVariable long id){
			return TipoRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.notFound().build());
			
		}
		
		@GetMapping("/categoria/{categoria}")
		public ResponseEntity<List<Tipo>> GetByTitulo(@PathVariable String tipo){
			return ResponseEntity.ok(TipoRepository.findAllByNomeCategoriaContainingIgnoreCase(tipo));
		}

		@PostMapping
		public ResponseEntity<Tipo> post (@RequestBody Tipo tipo ){
			return ResponseEntity.status(HttpStatus.CREATED).body(TipoRepository.save(tipo));
			
		}
		
		@PutMapping
		public ResponseEntity<Tipo> put (@RequestBody Tipo tipo ){
			return ResponseEntity.status(HttpStatus.OK).body(TipoRepository.save(tipo));
		}
		
		@DeleteMapping("/{id}")
		public void  delete(@PathVariable long id ) {
			TipoRepository.deleteById(id);
		
		
	}
	
	
	
	

}
