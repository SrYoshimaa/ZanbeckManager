package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import main.models.Estoque;
import main.models.Produto;
	
public interface EstoqueRepository extends JpaRepository<Estoque,Long>{
	Estoque findById(long id);
	@Query("SELECT SUM(e.quantidade) from Estoque as e where e.produto = :prod")
	int somaProduto(@Param("prod") Produto prod);
}
