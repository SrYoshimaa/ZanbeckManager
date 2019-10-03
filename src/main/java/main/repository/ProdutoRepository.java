package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import main.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long>{
	Produto findById(String id);
	
}
