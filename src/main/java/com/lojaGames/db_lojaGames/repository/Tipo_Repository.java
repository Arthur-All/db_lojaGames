package com.lojaGames.db_lojaGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lojaGames.db_lojaGames.model.Tipo;

@Repository
public interface Tipo_Repository extends JpaRepository<Tipo, Long> {
	public List<Tipo> findAllByNomeCategoriaContainingIgnoreCase (String nomeCategoria);
}
