package com.lojaGames.db_lojaGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojaGames.db_lojaGames.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	List<Produto> findAllByNomeContainigIgnoreCase();
	List<Produto> findAllByValorContainigIgnoreCase();
}
