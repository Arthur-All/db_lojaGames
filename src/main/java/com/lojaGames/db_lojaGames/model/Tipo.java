package com.lojaGames.db_lojaGames.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tipo")
public class Tipo {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY )
public long id;
	
@NotNull
private String nomeCategoria;

@OneToMany(mappedBy = "tipo", cascade = CascadeType.ALL)
private List<Produto> produtos;




public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getNomeCategoria() {
	return nomeCategoria;
}

public void setNomeCategoria(String nomeCategoria) {
	this.nomeCategoria = nomeCategoria;
}






}
