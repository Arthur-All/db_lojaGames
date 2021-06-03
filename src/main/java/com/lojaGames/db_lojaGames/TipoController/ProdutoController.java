package com.lojaGames.db_lojaGames.TipoController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojaGames.db_lojaGames.model.Produto;
import com.lojaGames.db_lojaGames.repository.ProdutoRepository;



@CrossOrigin("*")
@RequestMapping("/produto")
@RestController
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository respo;
	
	@GetMapping
	ResponseEntity< List<Produto>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(respo.findAll());
		
	}
	
	@GetMapping("/id/{id}")
	ResponseEntity <Produto> getById(@PathVariable Long id ){
		return respo.findById(id).map(resp-> ResponseEntity.status(HttpStatus.OK).body(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	ResponseEntity<List<Produto>> getNome (@PathVariable String nome){
		return ResponseEntity.status(HttpStatus.OK).body(respo.findAllByNomeContainigIgnoreCase());
	}
	
	@PostMapping
	ResponseEntity <Produto> posta(@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(respo.save(produto));
	}
	@PutMapping
	ResponseEntity<Produto> put(@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.OK).body(respo.save(produto));
	}
	
	@DeleteMapping("/{id}")
	 void deleta (@PathVariable long id){
	 respo.deleteById(id); 
		
	}
}
